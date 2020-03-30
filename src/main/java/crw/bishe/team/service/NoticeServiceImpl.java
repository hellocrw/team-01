package crw.bishe.team.service;

import crw.bishe.team.dto.NoticeDto;
import crw.bishe.team.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<NoticeDto> getNoticesByProId(String proId) {
        Long key = Long.parseLong(proId);
        return noticeMapper.getNoticesByProId(key);
    }
}
