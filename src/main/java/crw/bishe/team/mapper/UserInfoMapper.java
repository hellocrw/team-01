package crw.bishe.team.mapper;

import crw.bishe.team.dto.UserDto;
import crw.bishe.team.entity.UserInfo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper extends Mapper<UserInfo> {

    /**
     * 根据用户ID获取用户信息
     * @param userId
     * @return
     */
    @Select("SELECT user_info.* FROM user_info WHERE user_info.`user_id` = #{userId}")
    UserDto getUserInfoByUserId(Long userId);

    /**
     * 获取管理员信息
     * @return
     */
    @Select("SELECT user_info.* FROM user_info WHERE user_info.`role_id` IN (SELECT user_roles.`id` FROM user_roles WHERE user_roles.`auth`='ADMIN');")
    List<UserDto> getAdminInfo();

    /**
     * 获取用户信息
     * @return
     */
    @Select("SELECT user_info.* FROM user_info WHERE user_info.`role_id` IN (SELECT user_roles.`id` FROM user_roles WHERE user_roles.`auth`='USER');")
    List<UserDto> getUserInfo();

    /**
     * 通过团队ID获取团队的队长信息
     * @param teamId
     * @return
     */
    @Select("SELECT user_info.* FROM user_info, user_team WHERE user_info.`user_id` = user_team.`user_id` AND user_team.`team_id` = #{teamId} AND user_team.`is_leader` = '1';")
    UserDto getLeaderByTeamId(Long teamId);

}