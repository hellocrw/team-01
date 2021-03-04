package crw.bishe.team.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import crw.bishe.team.dto.AlterPasswordDto;
import crw.bishe.team.dto.UserRegisterDto;
import crw.bishe.team.entity.auth.AuthRole;
import crw.bishe.team.entity.auth.AuthUser;
import crw.bishe.team.entity.auth.UserRole;
import crw.bishe.team.mapper.auth.AuthRoleMapper;
import crw.bishe.team.mapper.auth.AuthUserMapper;
import crw.bishe.team.mapper.auth.OperatorLogMapper;
import crw.bishe.team.mapper.auth.UserRoleMapper;
import crw.bishe.team.service.auth.IAuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {

    private OperatorLogMapper operatorLogMapper;

    private AuthUserMapper authUserMapper;

    private AuthRoleMapper authRoleMapper;

    private UserRoleMapper userRoleMapper;

    private RedisTemplate redisTemplate;

    @Autowired
    public AuthUserServiceImpl(OperatorLogMapper operatorLogMapper,
                               AuthUserMapper authUserMapper,
                               AuthRoleMapper authRoleMapper,
                               UserRoleMapper userRoleMapper,
                               RedisTemplate redisTemplate) {
        this.operatorLogMapper = operatorLogMapper;
        this.authUserMapper = authUserMapper;
        this.authRoleMapper = authRoleMapper;
        this.userRoleMapper = userRoleMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public  IPage<AuthUser> findListByPage(Integer page, Integer pageCount){
        IPage<AuthUser> wherePage = new Page<>(page, pageCount);
        AuthUser where = new AuthUser();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AuthUser authUser){
        return baseMapper.insert(authUser);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AuthUser authUser){
        return baseMapper.updateById(authUser);
    }

    @Override
    public AuthUser findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public AuthUser selectByUsername(String username) {
        AuthUser authUser = baseMapper.selectOne(new QueryWrapper<AuthUser>().eq("USER_NAME", username));
        return authUser;
    }

    @Override
    @Transactional
    public String register(UserRegisterDto userRegisterDto) {
        // 判断用户名是否存在
        AuthUser user = baseMapper.selectOne(new QueryWrapper<AuthUser>().eq("USER_NAME", userRegisterDto.getUsername()));
        if (Objects.nonNull(user)) return "用户名已经存在";
        // 权限用户表插入
        AuthUser authUser = new AuthUser();
        authUser.setRevision(1);
        authUser.setCreatedBy(userRegisterDto.getUsername());
        authUser.setCreatedTime(new Date());
        authUser.setUserId(UUID.randomUUID().toString());
        authUser.setPassword(BCrypt.hashpw(userRegisterDto.getPassword(), BCrypt.gensalt()));
        authUser.setUserName(userRegisterDto.getUsername());
        authUser.setUserGroupId(userRegisterDto.getUserGroupId());
        baseMapper.insert(authUser);
        // 插入角色表
        AuthRole authRole = new AuthRole();
        authRole.setCreatedBy(userRegisterDto.getUsername());
        authRole.setCreatedTime(new Date());
        authRole.setRoleId(UUID.randomUUID().toString());
        authRole.setRoleName(userRegisterDto.getRole());
        authRoleMapper.insert(authRole);
        // 插入用户角色关联表
        UserRole userRole = new UserRole();
        userRole.setCreatedBy(userRegisterDto.getUsername());
        userRole.setCreatedTime(new Date());
        userRole.setUserRoleId(UUID.randomUUID().toString());
        userRole.setUserId(authUser.getUserId());
        userRole.setRoleId(authRole.getRoleId());
        int result = userRoleMapper.insert(userRole);
        if (result > 0)
            return "注册成功";
        else {
            return "注册失败";
        }
    }

    @Override
    @Transactional
    public String alterPassword(AlterPasswordDto alterPasswordDto, HttpServletRequest request) {
        if (alterPasswordDto.getNewPassword().equals(alterPasswordDto.getConfirmPassword())){
            return "密码不一致";
        }
        HttpSession session = request.getSession();
        // 获取session域的用户名
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        AuthUser authUser = baseMapper.selectOne(new QueryWrapper<AuthUser>().eq("USER_NAME", user.getUsername()));
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean matches = bc.matches(alterPasswordDto.getOldPassword(), authUser.getPassword());
        if (matches){
            authUser.setPassword(BCrypt.hashpw(alterPasswordDto.getNewPassword(), BCrypt.gensalt()));
            baseMapper.updateById(authUser);
            return "修改密码成功";
        }
        return "修改密码失败";
    }

    @Override
    public Long getOnlineUser() {
        Long onlineUser = 0L;
        // 获取redis缓存在线用户的数据
        SetOperations setOperations = redisTemplate.opsForSet();
        if (redisTemplate.hasKey("onlineUser")){
            Set onlineUser1 = setOperations.members("onlineUser");
            onlineUser = Long.valueOf(onlineUser1.size());
        }
        return onlineUser;
    }

    @Override
    public Long getAllUsers() {
        return authUserMapper.getAllUsers();
    }

}
