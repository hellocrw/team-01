package crw.bishe.team.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "invite")
public class Invite {
    /**
     * ID
     */
    @Id
    @Column(name = "invite_id")
    private Long inviteId;

    /**
     * 队长ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 团队ID
     */
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 邀请时间
     */
    private Date date;

    /**
     * 邀请状态
     */
    private String status;

    /**
     * 获取ID
     *
     * @return invite_id - ID
     */
    public Long getInviteId() {
        return inviteId;
    }

    /**
     * 设置ID
     *
     * @param inviteId ID
     */
    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    /**
     * 获取队长ID
     *
     * @return user_id - 队长ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置队长ID
     *
     * @param userId 队长ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
     * 获取邀请时间
     *
     * @return date - 邀请时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置邀请时间
     *
     * @param date 邀请时间
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取邀请状态
     *
     * @return status - 邀请状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置邀请状态
     *
     * @param status 邀请状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}