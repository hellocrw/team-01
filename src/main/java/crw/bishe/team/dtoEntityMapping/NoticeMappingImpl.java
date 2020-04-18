package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.NoticeDto;
import crw.bishe.team.entity.Notice;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component("noticeMapping")
public class NoticeMappingImpl implements NoticeMapping {
    @Override
    public Notice toEntity(NoticeDto noticeDto) {
        if (noticeDto == null){
            return null;
        }
        Notice notice = new Notice();
        if (noticeDto.getNoticeId() == null || noticeDto.getNoticeId() == ""){
            notice.setNoticeId(null);
        }
        notice.setUserId(Long.parseLong(noticeDto.getUserId()));
        notice.setUserName(noticeDto.getUserName());
        notice.setProId(Long.parseLong(noticeDto.getProId()));
        notice.setProName(noticeDto.getProName());
        notice.setNoticeContent(noticeDto.getNoticeContent());
        notice.setCreateTime(Date.valueOf(noticeDto.getCreateTime()));
        notice.setStatus(Byte.valueOf(noticeDto.getStatus()));
        return notice;
    }
}
