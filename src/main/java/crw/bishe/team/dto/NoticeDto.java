package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class NoticeDto implements Serializable {
    private String noticeId;
    private String userId;
    private String userName;
    private String proId;
    private String proName;
    private String noticeContent;
    private String createTime;
    private String status;
}
