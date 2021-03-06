package crw.bishe.team.mapper;

import crw.bishe.team.entity.UserRoles;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    @Insert("INSERT INTO user_roles VALUES (null, #{username}, #{password}, #{auth})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer userRegister(UserRoles userRoles);

    /**
     * 根据用户名获取用户权限
     * @param username
     * @return
     */
    @Select("SELECT user_roles.`auth` FROM user_roles WHERE user_roles.`username`=#{arg0};")
    String getAuth(String username);

    /**
     * 获取加密后的密码
     * @param username
     * @return
     */
    @Select("SELECT user_roles.`password` FROM user_roles WHERE user_roles.`username`=#{arg0};")
    String getPassword(String username);

    /**
     * 修改密码
     * @param username
     * @return
     */
    @Update("UPDATE user_roles SET user_roles.`password` = #{param2} WHERE user_roles.`username`=#{param1};")
    Integer alterPassword(String username, String newPassword);
}