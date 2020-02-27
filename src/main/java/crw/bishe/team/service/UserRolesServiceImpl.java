package crw.bishe.team.service;

import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.dtoEntityMapping.UserRolesMapping;
import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.mapper.UserRolesMapper;
import crw.bishe.team.security.SecurityUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @description Description 自定义认证用户获取服务类
 * @Author crw
 * @create 2020/1/18
 * @Time 16:11
 **/
@Service
public class UserRolesServiceImpl implements UserRolesService  {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Autowired
    private UserRolesMapping userRolesMapping;

    /**
     * 用户注册
     * @param userRolesDto
     * @return
     */
    @Override
    public String register(UserRolesDto userRolesDto) {
        UserRoles userRoles = userRolesMapping.toEntity(userRolesDto);
        if(userRoles.getUsername() == null || userRoles.getPassword() == null){
            return "用户名或密码不能为空";
        }
        if(userRolesMapper.findByUserName(userRoles.getUsername()) != null){
            return "用户名已经存在";
        }
        // 密码加密
        String pass = BCrypt.hashpw(userRoles.getPassword(), BCrypt.gensalt());
        userRoles.setPassword(pass);
        userRoles.setAuth("USER");
        userRolesMapper.insert(userRoles);
        return "用户注册成功";
    }

    @Override
    public String getAuth(String username) {
        return null;
    }

    /**
     * 自定义用户连接数据库查询，实现用户登录功能
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("用户登录的用户名为：" + username);

        System.out.println("调用了UserDetailsService的loadUserByUsername方法");
        UserRoles userRoles = userRolesMapper.findByUserName(username);
        if (userRoles == null){
            return null;
        }
//        return new SecurityUserDto(userRoles);
        UserDetails userDetails = User.withUsername(userRoles.getUsername()).password(userRoles.getPassword()).authorities(userRoles.getAuth()).build();
        return userDetails;
    }
}
