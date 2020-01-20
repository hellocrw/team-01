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
    private String team_id;
    private String team_name;
    private String is_leader;
    private String team_describe;
}
