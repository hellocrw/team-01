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
     * @param username
     * @param password
     */
    @Select("INSERT INTO user_roles(username, PASSWORD) VALUE (#{arg0},#{arg1});")
    void register(String username, String password);
}