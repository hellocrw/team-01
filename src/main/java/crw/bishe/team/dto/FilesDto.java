package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class FilesDto implements Serializable {
    private String fileId;
    private String fileName;
    private String userId;
    private String userName;
    private String fileLink;
    private String proId;
    private String proName;
    private String uploadTime;
}