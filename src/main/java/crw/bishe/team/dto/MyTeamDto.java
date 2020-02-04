package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/20 0020
 * @Time 14:28
 */
@Data
@ToString(callSuper = true)
public class MyTeamDto {
    private String id;
    private String teamId;
    private String teamName;
    private String isLeader;
    private String teamDescribe;
}
