package crw.bishe.team.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 15:45
 */
@Data
public class MyProListDto implements Serializable {
    private String teamId;
    private String teamName;
    private String proId;
    private String proName;
    private String proDescribe;
    private String proDate;
    private String proStartTime;
    private String proEndTime;
    private String proStatus;
    private String proType;
    private String proCurrentNum;
    private String proLimiedNum;
    private String seeNum;
    private String staff;
}
