package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.NoticeDto;
import crw.bishe.team.entity.Notice;

public interface NoticeMapping {
    Notice toEntity(NoticeDto noticeDto);
}
