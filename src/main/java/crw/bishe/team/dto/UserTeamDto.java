package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserTeamDto implements Serializable {
    private String utId;
    private String userId;
    private String userName;
    private String teamId;
    private String teamName;
    private String isLeader;
}
