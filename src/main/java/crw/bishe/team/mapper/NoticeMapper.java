package crw.bishe.team.mapper;

import crw.bishe.team.dto.NoticeDto;
import crw.bishe.team.entity.Notice;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NoticeMapper extends Mapper<Notice> {

    /**
     * 通过项目ID获取公告信息
     * @param proId
     * @return
     */
    @Select("SELECT notice.* FROM notice WHERE notice.`pro_id` = #{proId};")
    List<NoticeDto> getNoticesByProId(Long proId);
}