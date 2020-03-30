package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserTeamDto {
    private String utId;
    private String userId;
    private String userName;
    private String teamId;
    private String teamName;
    private String isLeader;
}
