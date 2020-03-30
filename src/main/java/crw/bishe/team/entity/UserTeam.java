package crw.bishe.team.entity;

import javax.persistence.*;

@Table(name = "user_team")
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
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 团队ID
     */
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 团队名称
     */
    @Column(name = "team_name")
    private String teamName;

    /**
     * 是否是队长
     */
    @Column(name = "is_leader")
    private Byte isLeader;

    /**
     * 获取ID
     *
     * @return ut_id - ID
     */
    public Long getUtId() {
        return utId;
    }

    /**
     * 设置ID
     *
     * @param utId ID
     */
    public void setUtId(Long utId) {
        this.utId = utId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取团队ID
     *
     * @return team_id - 团队ID
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * 设置团队ID
     *
     * @param teamId 团队ID
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * 获取团队名称
     *
     * @return team_name - 团队名称
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 设置团队名称
     *
     * @param teamName 团队名称
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * 获取是否是队长
     *
     * @return is_leader - 是否是队长
     */
    public Byte getIsLeader() {
        return isLeader;
    }

    /**
     * 设置是否是队长
     *
     * @param isLeader 是否是队长
     */
    public void setIsLeader(Byte isLeader) {
        this.isLeader = isLeader;
    }
}