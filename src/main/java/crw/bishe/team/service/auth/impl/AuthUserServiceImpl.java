package crw.bishe.team.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import crw.bishe.team.dto.AlterPasswordDto;
import crw.bishe.team.dto.UserRegisterDto;
import crw.bishe.team.entity.auth.AuthUser;
import crw.bishe.team.mapper.auth.AuthUserMapper;
import crw.bishe.team.service.auth.IAuthUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        AuthUser authUser = baseMapper.selectOne(new QueryWrapper<AuthUser>().eq("USER_NAME", userRegisterDto.getUsername()));
        if (Objects.nonNull(authUser)) return "用户名已经存在";
        AuthUser user = new AuthUser();
        user.setRevision(1);
        user.setCreatedBy("caorongwu");
        user.setCreatedTime(new Date());
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(BCrypt.hashpw(userRegisterDto.getPassword(), BCrypt.gensalt()));
        user.setUserName(userRegisterDto.getUsername());
        user.setUserGroupId(userRegisterDto.getUserGroupId());
        int insert = baseMapper.insert(user);
        if (insert > 0)
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

}
