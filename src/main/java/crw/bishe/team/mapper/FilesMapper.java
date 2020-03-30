package crw.bishe.team.mapper;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.entity.Files;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FilesMapper extends Mapper<Files> {

    /**
     * 通过项目ID查询文件信息
     * @param proId
     * @return
     */
    @Select("SELECT files.* FROM files WHERE files.`pro_id`=#{proId};")
    List<FilesDto> getFilesByProId(Long proId);
}