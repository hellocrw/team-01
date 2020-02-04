package crw.bishe.team.mapper;

import crw.bishe.team.dto.ProTypeDto;
import crw.bishe.team.entity.ProType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProTypeMapper extends Mapper<ProType> {

    @Select("SELECT * FROM pro_type")
    List<ProTypeDto> selectProTypeAll();
}