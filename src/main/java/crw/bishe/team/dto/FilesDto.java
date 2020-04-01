package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FilesDto {
    private String fileId;
    private String fileName;
    private String userId;
    private String userName;
    private String fileLink;
    private String proId;
    private String proName;
    private String uploadTime;
}