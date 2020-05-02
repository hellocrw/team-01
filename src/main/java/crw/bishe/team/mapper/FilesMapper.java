package crw.bishe.team.mapper;

import crw.bishe.team.dto.FilesDto;
import crw.bishe.team.entity.Files;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
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

    /**
     * proIds --delete--> files
     * @param proIds
     * @return
     */
    @Delete("<script>"
            + "DELETE FROM files WHERE pro_id IN "
            + "<foreach item='item' index='index' collection='proIds' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    Integer delectByProIds(@Param("proIds") List<Long> proIds);
}