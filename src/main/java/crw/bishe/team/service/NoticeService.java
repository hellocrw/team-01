package crw.bishe.team.service;

import crw.bishe.team.dto.NoticeDto;
import crw.bishe.team.entity.Notice;

import java.util.List;

public interface NoticeService {
    /**
     * 通过项目ID查询所有公告信息
     * @param proId
     * @return
     */
    List<NoticeDto> getNoticesByProId(String proId);

    /**
     * 保存公告
     * @param noticeDto
     * @return
     */
    int save(NoticeDto noticeDto);

    Integer deleteByProIds(List<String> proIds);
}
