package crw.bishe.team.mapper;

import crw.bishe.team.entity.UserRoles;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserRolesMapper extends Mapper<UserRoles> {

    /**
     * 用户名是否已经存在
     * @param username 用户名
     * @return
     */
    @Select("SELECT * FROM user_roles WHERE user_roles.`username`= #{arg0};")
    UserRoles findByUserName(String username);

    /**
     * 用户名和密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Select("SELECT user_roles.`username`,user_roles.`password` FROM user_roles WHERE user_roles.`username`= #{username} AND user_roles.`password`= #{password};")
    void isExistPassword(String username, String password);

    /**
     * 用户注册
     * @param userRoles
     */
    @Select("INSERT INTO user_roles VALUE (#arg0);")
    void register(UserRoles userRoles);

    /**
     * 根据用户名获取用户权限
     * @param username
     * @return
     */
    @Select("SELECT user_roles.`auth` FROM user_roles WHERE user_roles.`username`=#{arg0};")
    String getRoles(String username);
}