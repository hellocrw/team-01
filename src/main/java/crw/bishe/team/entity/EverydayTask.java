package crw.bishe.team.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "everyday_task")
public class EverydayTask {
    /**
     * ID号
     */
    @Id
    @Column(name = "everyday_task_id")
    private Long everydayTaskId;

    /**
     * 每天任务内容
     */
    private String content;

    /**
     * 是否完成任务，“0”未完成，“1”已完成
     */
    private Byte finish;

    /**
     * 打卡时间
     */
    @Column(name = "clock_time")
    private Date clockTime;

    /**
     * 创建人ID号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 获取ID号
     *
     * @return everyday_task_id - ID号
     */
    public Long getEverydayTaskId() {
        return everydayTaskId;
    }

    /**
     * 设置ID号
     *
     * @param everydayTaskId ID号
     */
    public void setEverydayTaskId(Long everydayTaskId) {
        this.everydayTaskId = everydayTaskId;
    }

    /**
     * 获取每天任务内容
     *
     * @return content - 每天任务内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置每天任务内容
     *
     * @param content 每天任务内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取是否完成任务，“0”未完成，“1”已完成
     *
     * @return finish - 是否完成任务，“0”未完成，“1”已完成
     */
    public Byte getFinish() {
        return finish;
    }

    /**
     * 设置是否完成任务，“0”未完成，“1”已完成
     *
     * @param finish 是否完成任务，“0”未完成，“1”已完成
     */
    public void setFinish(Byte finish) {
        this.finish = finish;
    }

    /**
     * 获取打卡时间
     *
     * @return clock_time - 打卡时间
     */
    public Date getClockTime() {
        return clockTime;
    }

    /**
     * 设置打卡时间
     *
     * @param clockTime 打卡时间
     */
    public void setClockTime(Date clockTime) {
        this.clockTime = clockTime;
    }

    /**
     * 获取创建人ID号
     *
     * @return user_id - 创建人ID号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置创建人ID号
     *
     * @param userId 创建人ID号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "EverydayTask{" +
                "everydayTaskId=" + everydayTaskId +
                ", content='" + content + '\'' +
                ", finish=" + finish +
                ", clockTime=" + clockTime +
                ", userId=" + userId +
                '}';
    }
}