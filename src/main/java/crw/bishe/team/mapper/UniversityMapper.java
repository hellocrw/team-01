package crw.bishe.team.mapper;

import crw.bishe.team.dto.UniversityDto;
import crw.bishe.team.entity.University;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UniversityMapper extends Mapper<University> {

    @Select("SELECT * FROM university")
    List<UniversityDto> selectUniversityAll();
}