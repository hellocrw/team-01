package crw.bishe.team.mapper;

import crw.bishe.team.entity.Team;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TeamMapper extends Mapper<Team> {

    @Select("SELECT team.`team_id`,team.`team_name`,user_team.`is_leader`,team.`team_describe` FROM team , user_info ,user_team WHERE team.`team_id` = user_team.`team_id` AND user_team.`user_id` = user_info.`user_id`AND user_info.`user_id` = #{id}")
    List<Map> getMyTeamList(Long id);

    /**
     * 通过团队ID获取该团队的成员列表
     * @param teamId
     * @return
     */
    @Select("SELECT user_team.`ut_id`,user_team.`team_id`,user_info.`user_id`,user_info.`user_name` FROM user_team, user_info \n" +
            "WHERE user_team.`user_id`=user_info.`user_id` AND  user_team.`team_id`= #{arg0};")
    List<Map> getMemberList(Long teamId);

    /**
     * 查找校内所有团队
     * @param user_id
     * @return
     */
    @Select("SELECT * FROM team WHERE team_scope IN (SELECT university FROM user_info WHERE user_info.`user_id` = #{arg0};")
    List<Team> getTeamsByUniversity(Long user_id);

    /**
     * 查找校外所有团队
     * @return
     */
    @Select("SELECT * FROM team WHERE team_scope = '所有学校';")
    List<Team> getTeamsByOtherUniversity();

}