package crw.bishe.team.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 16:09
 */
@Data
public class TeamProDto implements Serializable {
//    private String id;
    private String proId;
    private String proName;
    private String proDescribe;
    private String proStartTime;
    private String proEndTime;
    private String proStatus;
    private String proType;
    private String proNature;
    private String proNum;
    private String proCurrentNum;
    private String proLimiedNum;
    private String seeNum;
    private String staffList;
    private String teamId;
    private String teamName;
    private String leaderName;
    private String teamDescribe;
    private String university;
}
