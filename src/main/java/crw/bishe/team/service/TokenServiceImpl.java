package crw.bishe.team.service;

import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.mapper.UserRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("用户登录的用户名为：" + username);
//        System.out.println("调用了UserDetailsService的loadUserByUsername方法");
//        UserRoles userRoles = userRolesMapper.findByUserName(username);
//        if (userRoles == null){
//            return null;
//        }
////        return new SecurityUserDto(userRoles);
//        UserDetails userDetails = User.withUsername(userRoles.getUsername()).password(userRoles.getPassword()).authorities(userRoles.getAuth()).build();
//        return userDetails;
        return null;
    }
}
