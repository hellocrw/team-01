package crw.bishe.team.service;

import crw.bishe.team.dto.NoticeDto;
import crw.bishe.team.dtoEntityMapping.NoticeMapping;
import crw.bishe.team.entity.Notice;
import crw.bishe.team.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeMapping noticeMapping;

    @Override
    public List<NoticeDto> getNoticesByProId(String proId) {
        Long key = Long.parseLong(proId);
        return noticeMapper.getNoticesByProId(key);
    }

    @Override
    public int save(NoticeDto noticeDto) {
        Notice notice = noticeMapping.toEntity(noticeDto);
        return noticeMapper.insert(notice);
    }
}
