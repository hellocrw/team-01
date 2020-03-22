package crw.bishe.team.entity;

import javax.persistence.*;

@Table(name = "sub_task")
public class SubTask {
    /**
     * 子任务ID
     */
    @Id
    private Long subTaskId;

    /**
     * 任务ID
     */
    @Column(name = "task_id")
    private Long TaskId;

    /**
     * 子任务内容
     */
    @Column(name = "sub_task_content")
    private String subTaskContent;

    /**
     * 子任务负责人
     */
    @Column(name = "sub_task_charger")
    private String subTaskCharger;

    /**
     * 子任务状态
     */
    @Column(name = "sub_task_status")
    private Byte subTaskStatus;

    public Long getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(Long subTaskId) {
        this.subTaskId = subTaskId;
    }

    public Long getTaskId() {
        return TaskId;
    }

    public void setTaskId(Long taskId) {
        TaskId = taskId;
    }

    /**
     * 获取子任务内容
     *
     * @return sub_task_content - 子任务内容
     */
    public String getSubTaskContent() {
        return subTaskContent;
    }

    /**
     * 设置子任务内容
     *
     * @param subTaskContent 子任务内容
     */
    public void setSubTaskContent(String subTaskContent) {
        this.subTaskContent = subTaskContent;
    }

    /**
     * 获取子任务负责人
     *
     * @return sub_task_charger - 子任务负责人
     */
    public String getSubTaskCharger() {
        return subTaskCharger;
    }

    /**
     * 设置子任务负责人
     *
     * @param subTaskCharger 子任务负责人
     */
    public void setSubTaskCharger(String subTaskCharger) {
        this.subTaskCharger = subTaskCharger;
    }

    /**
     * 获取子任务状态
     *
     * @return sub_task_status - 子任务状态
     */
    public Byte getSubTaskStatus() {
        return subTaskStatus;
    }

    /**
     * 设置子任务状态
     *
     * @param subTaskStatus 子任务状态
     */
    public void setSubTaskStatus(Byte subTaskStatus) {
        this.subTaskStatus = subTaskStatus;
    }
}