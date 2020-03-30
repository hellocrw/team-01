package crw.bishe.team.service;

import crw.bishe.team.dto.NoticeDto;

import java.util.List;

public interface NoticeService {
    /**
     * 通过项目ID查询所有公告信息
     * @param proId
     * @return
     */
    List<NoticeDto> getNoticesByProId(String proId);
}
