package crw.bishe.team.mapper;

import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.entity.UserTeam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserTeamMapper extends Mapper<UserTeam> {

    /**
     * 通过团队ID获取用户信息
     * @param teamId
     * @return
     */
    @Select("SELECT user_team.* FROM user_team WHERE team_id = #{teamId};")
    List<UserTeamDto> getUserByTeamId(Long teamId);

    /**
     * 根据团队ID删除用户团队信息
     * @param teamId
     * @return
     */
    @Delete("DELETE FROM user_team WHERE team_id = #{teamId}")
    Integer deleteByTeamId(Long teamId);

    /**
     * 判断团队中是否有这个用户存在
     * @param userId
     * @param teamId
     * @return
     */
    @Select("SELECT COUNT(*) FROM user_team WHERE user_team.`user_id` = #{arg0} AND user_team.`team_id` = #{arg1}")
    Integer existInTeam(Long userId, Long teamId);

}