package crw.bishe.team.mapper;

import crw.bishe.team.dto.TeamTypeDto;
import crw.bishe.team.entity.TeamType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TeamTypeMapper extends Mapper<TeamType> {
    /**
     * 查询团队类型
     * @return
     */
    @Select("select * from team_type")
    List<TeamTypeDto> selectTeamType();
}