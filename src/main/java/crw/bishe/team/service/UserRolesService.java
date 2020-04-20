package crw.bishe.team.service;

import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.entity.UserRoles;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/31 0031
 * @Time 15:06
 */
public interface UserRolesService {
    /**
     * 用户注册
     * @param userRolesDto
     * @return
     */
    String register(UserRolesDto userRolesDto);

    /**
     * 获取用户权限
     * @param username 用户名
     * @return
     */
    String getAuth(String username);

}
