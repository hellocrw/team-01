package crw.bishe.team.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "task")
public class Task {
    /**
     * ID
     */
    @Id
    @Column(name = "task_id")
    private Long taskId;

    /**
     * 团队ID
     */
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 项目ID
     */
    @Column(name = "pro_id")
    private Long proId;

    /**
     * 任务创建时间
     */
    @Column(name = "task_create_time")
    private Date taskCreateTime;

    /**
     * 任务开始时间
     */
    @Column(name = "task_start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date taskStartTime;

    /**
     * 任务结束时间
     */
    @Column(name = "task_end_time")
    private Date taskEndTime;

    /**
     * 任务内容
     */
    @Column(name = "task_content")
    private String taskContent;

    /**
     * 任务负责人ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 任务状态
     */
    @Column(name = "task_status")
    private Byte taskStatus;

    /**
     * 备注
     */
    @Column(name = "task_mark")
    private String taskMark;

    /**
     * 获取ID
     *
     * @return task_id - ID
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 设置ID
     *
     * @param taskId ID
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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
     * 获取项目ID
     *
     * @return pro_id - 项目ID
     */
    public Long getProId() {
        return proId;
    }

    /**
     * 设置项目ID
     *
     * @param proId 项目ID
     */
    public void setProId(Long proId) {
        this.proId = proId;
    }

    /**
     * 获取任务创建时间
     *
     * @return task_create_time - 任务创建时间
     */
    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    /**
     * 设置任务创建时间
     *
     * @param taskCreateTime 任务创建时间
     */
    public void setTaskCreateTime(Date taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    /**
     * 获取任务开始时间
     *
     * @return task_start_time - 任务开始时间
     */
    public Date getTaskStartTime() {
        return taskStartTime;
    }

    /**
     * 设置任务开始时间
     *
     * @param taskStartTime 任务开始时间
     */
    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    /**
     * 获取任务结束时间
     *
     * @return task_end_time - 任务结束时间
     */
    public Date getTaskEndTime() {
        return taskEndTime;
    }

    /**
     * 设置任务结束时间
     *
     * @param taskEndTime 任务结束时间
     */
    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    /**
     * 获取任务内容
     *
     * @return task_content - 任务内容
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * 设置任务内容
     *
     * @param taskContent 任务内容
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
     * 获取任务负责人
     *
     * @return userId - 任务负责人ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置任务负责人
     *
     * @param userId 任务负责人ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取任务状态
     *
     * @return task_status - 任务状态
     */
    public Byte getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置任务状态
     *
     * @param taskStatus 任务状态
     */
    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取备注
     *
     * @return task_mark - 备注
     */
    public String getTaskMark() {
        return taskMark;
    }

    /**
     * 设置备注
     *
     * @param taskMark 备注
     */
    public void setTaskMark(String taskMark) {
        this.taskMark = taskMark;
    }
}