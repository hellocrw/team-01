package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NoticeDto {
    private String noticeId;
    private String userId;
    private String userName;
    private String proId;
    private String proName;
    private String noticeContent;
    private String createTime;
    private String status;
}
