package crw.bishe.team.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "user_team")
@Data
public class UserTeam {
    /**
     * ID
     */
    @Id
    @Column(name = "ut_id")
    private Long utId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 团队ID
     */
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 是否是队长
     */
    @Column(name = "is_leader")
    private Byte isLeader;

}