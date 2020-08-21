package crw.bishe.team.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "project")
public class Project implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "pro_id")
    private Long proId;

    /**
     * 项目名称
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 队长名称
     */
    @Column(name = "leader_name")
    private String leaderName;

    /**
     * 项目描述
     */
    @Column(name = "pro_describe")
    private String proDescribe;

    /**
     * 项目创建时间
     */
    @Column(name = "pro_date")
    private Date proDate;

    /**
     * 项目开始时间
     */
    @Column(name = "pro_start_time")
    private Date proStartTime;

    /**
     * 项目结束时间
     */
    @Column(name = "pro_end_time")
    private Date proEndTime;

    /**
     * 项目当前状态
     */
    @Column(name = "pro_status")
    private String proStatus;

    /**
     * 所属团队id号
     */
    @Column(name = "team_id")
    private String teamId;

    /**
     * 项目类型
     */
    @Column(name = "pro_type")
    private String proType;

    /**
     * 项目当前人数
     */
    @Column(name = "pro_current_num")
    private Integer proCurrentNum;

    /**
     * 项目限制人数
     */
    @Column(name = "pro_limied_num")
    private Integer proLimiedNum;

    /**
     * 查看人数
     */
    @Column(name = "see_num")
    private Integer seeNum;

    /**
     * 技术类型
     */
    private String staffList;

    /**
     * 需要人员类型
     */
    private String staff;

    /**
     * 项目
     */
    private List<Task> tasks;

    /**
     * 获取ID
     *
     * @return pro_id - ID
     */
    public Long getProId() {
        return proId;
    }

    /**
     * 设置ID
     *
     * @param proId ID
     */
    public void setProId(Long proId) {
        this.proId = proId;
    }

    /**
     * 获取项目名称
     *
     * @return pro_name - 项目名称
     */
    public String getProName() {
        return proName;
    }

    /**
     * 设置项目名称
     *
     * @param proName 项目名称
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * 获取队长名称
     *
     * @return leader_name - 队长名称
     */
    public String getLeaderName() {
        return leaderName;
    }

    /**
     * 设置队长名称
     *
     * @param leaderName 队长名称
     */
    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    /**
     * 获取项目描述
     *
     * @return pro_describe - 项目描述
     */
    public String getProDescribe() {
        return proDescribe;
    }

    /**
     * 设置项目描述
     *
     * @param proDescribe 项目描述
     */
    public void setProDescribe(String proDescribe) {
        this.proDescribe = proDescribe;
    }

    /**
     * 获取项目创建时间
     *
     * @return pro_date - 项目创建时间
     */
    public Date getProDate() {
        return proDate;
    }

    /**
     * 设置项目创建时间
     *
     * @param proDate 项目创建时间
     */
    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    /**
     * 获取项目开始时间
     *
     * @return pro_start_time - 项目开始时间
     */
    public Date getProStartTime() {
        return proStartTime;
    }

    /**
     * 设置项目开始时间
     *
     * @param proStartTime 项目开始时间
     */
    public void setProStartTime(Date proStartTime) {
        this.proStartTime = proStartTime;
    }

    /**
     * 获取项目结束时间
     *
     * @return pro_end_time - 项目结束时间
     */
    public Date getProEndTime() {
        return proEndTime;
    }

    /**
     * 设置项目结束时间
     *
     * @param proEndTime 项目结束时间
     */
    public void setProEndTime(Date proEndTime) {
        this.proEndTime = proEndTime;
    }

    /**
     * 获取项目当前状态
     *
     * @return pro_status - 项目当前状态
     */
    public String getProStatus() {
        return proStatus;
    }

    /**
     * 设置项目当前状态
     *
     * @param proStatus 项目当前状态
     */
    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    /**
     * 获取所属团队id号
     *
     * @return team_id - 所属团队id号
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * 设置所属团队id号
     *
     * @param teamId 所属团队id号
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    /**
     * 获取技术类型
     * @return
     */
    public String getStaffList() {
        return staffList;
    }

    /**
     * 设置技术类型
     * @param staffList
     */
    public void setStaffList(String staffList) {
        this.staffList = staffList;
    }

    /**
     * 获取项目类型
     *
     * @return pro_type - 项目类型
     */
    public String getProType() {
        return proType;
    }

    /**
     * 设置项目类型
     *
     * @param proType 项目类型
     */
    public void setProType(String proType) {
        this.proType = proType;
    }

    /**
     * 获取项目当前人数
     *
     * @return pro_current_num - 项目当前人数
     */
    public Integer getProCurrentNum() {
        return proCurrentNum;
    }

    /**
     * 设置项目当前人数
     *
     * @param proCurrentNum 项目当前人数
     */
    public void setProCurrentNum(Integer proCurrentNum) {
        this.proCurrentNum = proCurrentNum;
    }

    /**
     * 获取项目限制人数
     *
     * @return pro_limied_num - 项目限制人数
     */
    public Integer getProLimiedNum() {
        return proLimiedNum;
    }

    /**
     * 设置项目限制人数
     *
     * @param proLimiedNum 项目限制人数
     */
    public void setProLimiedNum(Integer proLimiedNum) {
        this.proLimiedNum = proLimiedNum;
    }

    /**
     * 获取查看人数
     *
     * @return see_num - 查看人数
     */
    public Integer getSeeNum() {
        return seeNum;
    }

    /**
     * 设置查看人数
     *
     * @param seeNum 查看人数
     */
    public void setSeeNum(Integer seeNum) {
        this.seeNum = seeNum;
    }

    /**
     * 获取需要人员类型
     *
     * @return staff - 需要人员类型
     */
    public String getStaff() {
        return staff;
    }

    /**
     * 设置需要人员类型
     *
     * @param staff 需要人员类型
     */
    public void setStaff(String staff) {
        this.staff = staff;
    }
}