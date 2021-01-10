package crw.bishe.team.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import crw.bishe.team.entity.auth.AuthRole;
import crw.bishe.team.entity.auth.AuthUser;
import crw.bishe.team.entity.auth.UserRole;
import crw.bishe.team.mapper.auth.AuthRoleMapper;
import crw.bishe.team.mapper.auth.UserRoleMapper;
import crw.bishe.team.service.auth.IAuthUserService;
import crw.bishe.team.service.auth.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    private IAuthUserService authUserService;

    private UserRoleMapper userRoleMapper;

    private AuthRoleMapper authRoleMapper;

    @Autowired
    public TokenServiceImpl(IAuthUserService authUserService,
                            UserRoleMapper userRoleMapper,
                            AuthRoleMapper authRoleMapper){
        this.authUserService = authUserService;
        this.userRoleMapper = userRoleMapper;
        this.authRoleMapper = authRoleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("调用了UserDetailsService的loadUserByUsername方法");
        AuthUser authUser = authUserService.selectByUsername(username);
        if (authUser == null){
            return null;
        }
        UserRole userRole = userRoleMapper.selectOne(new QueryWrapper<UserRole>().eq("USER_ID", authUser.getUserId()));
        AuthRole authRole = authRoleMapper.selectById(userRole.getRoleId());
//        return new JwtUserDto(userRoles);
        UserDetails userDetails = User.withUsername(authUser.getUserName()).password(authUser.getPassword()).authorities(authRole.getRoleName()).build();
        return userDetails;
    }
}
