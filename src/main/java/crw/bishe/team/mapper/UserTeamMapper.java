package crw.bishe.team.mapper;

import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.entity.UserTeam;
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
}