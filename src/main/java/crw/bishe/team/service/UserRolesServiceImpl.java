package crw.bishe.team.service;

import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.mapper.UserRolesMapper;
import crw.bishe.team.security.SecurityUserDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public String register(String username, String password) {
        if(username == null || password == null){
            return "用户名或密码不能为空";
        }
        if(userRolesMapper.findByUserName(username) != null){
            return "用户名已经存在";
        }
        // 密码加密
        String pass = BCrypt.hashpw(password, BCrypt.gensalt());
        userRolesMapper.register(username,pass);
        return "用户注册成功";
    }

    /**
     * 自定义用户连接数据库查询，实现用户登录功能
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("调用了UserDetailsService的loadUserByUsername方法");
        UserRoles userRoles = userRolesMapper.findByUserName(username);
        System.out.println(userRoles.toString());
        return new SecurityUserDto(userRoles);
    }
}
