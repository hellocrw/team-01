package crw.bishe.team.service;

import crw.bishe.team.entity.UserRoles;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/31 0031
 * @Time 15:06
 */
public interface UserRolesService extends UserDetailsService {
    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    String register(String username, String password);

}
