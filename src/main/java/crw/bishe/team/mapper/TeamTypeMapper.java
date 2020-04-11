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

    /**
     * 通过key查询value
     * @param key
     * @return
     */
    @Select("SELECT team_type.`value` FROM team_type WHERE team_type.`key` = #{key};")
    String getValueByKey(Long key);
}