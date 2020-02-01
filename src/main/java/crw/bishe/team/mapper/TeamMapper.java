package crw.bishe.team.mapper;

import crw.bishe.team.entity.Team;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TeamMapper extends Mapper<Team> {

    @Select("SELECT team.`team_id`,team.`team_name`,user_team.`is_leader`,team.`team_describe` FROM team , user_info ,user_team WHERE team.`team_id` = user_team.`team_id` AND user_team.`user_id` = user_info.`user_id`AND user_info.`user_id` = #{id}")
    List<Map> getMyTeamList(Long id);

}