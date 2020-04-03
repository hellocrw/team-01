package crw.bishe.team.entity;

import javax.persistence.*;

@Table(name = "user_item_remark")
public class UserItemRemark{
    /**
     * id号
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 团队id
     */
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 对团队的行为，1表示查看，2表示参与
     */
    @Column(name = "behavior_type")
    private String behaviorType;

    /**
     * 团队类型id
     */
    @Column(name = "team_type_id")
    private Long teamTypeId;

    /**
     * 获取id号
     *
     * @return id - id号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id号
     *
     * @param id id号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取团队id
     *
     * @return team_id - 团队id
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * 设置团队id
     *
     * @param teamId 团队id
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * 获取对团队的行为，1表示查看，2表示参与
     *
     * @return behavior_type - 对团队的行为，1表示查看，2表示参与
     */
    public String getBehaviorType() {
        return behaviorType;
    }

    /**
     * 设置对团队的行为，1表示查看，2表示参与
     *
     * @param behaviorType 对团队的行为，1表示查看，2表示参与
     */
    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    /**
     * 获取团队类型id
     *
     * @return team_type_id - 团队类型id
     */
    public Long getTeamTypeId() {
        return teamTypeId;
    }

    /**
     * 设置团队类型id
     *
     * @param teamTypeId 团队类型id
     */
    public void setTeamTypeId(Long teamTypeId) {
        this.teamTypeId = teamTypeId;
    }

}