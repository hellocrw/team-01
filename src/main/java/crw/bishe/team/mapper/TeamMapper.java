package crw.bishe.team.mapper;

import crw.bishe.team.dto.MyTeamDto;
import crw.bishe.team.entity.Team;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TeamMapper extends Mapper<Team> {

    @Select("SELECT team.`team_id`,team.`team_name`,user_team.`is_leader`,team.`team_describe` FROM team , users ,user_team WHERE team.`team_id` = user_team.`team_id` AND user_team.`user_id` = users.`user_id`AND users.`user_id` = #{id}")
    List<MyTeamDto> getMyTeamList(Long id);

}