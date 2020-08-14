package crw.bishe.team.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "everyday_task_log")
public class EverydayTaskLog {
    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 每天任务ID号
     */
    @Column(name = "everyday_id")
    private Long everydayId;

    /**
     * 每天任务内容
     */
    private String content;

    /**
     * 是否完成
     */
    private Byte finish;

    /**
     * 打卡时间
     */
    @Column(name = "clock_time")
    private Date clockTime;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 每天总结
     */
    private String summary;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取每天任务ID号
     *
     * @return everyday_id - 每天任务ID号
     */
    public Long getEverydayId() {
        return everydayId;
    }

    /**
     * 设置每天任务ID号
     *
     * @param everydayId 每天任务ID号
     */
    public void setEverydayId(Long everydayId) {
        this.everydayId = everydayId;
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
     * 获取是否完成
     *
     * @return finish - 是否完成
     */
    public Byte getFinish() {
        return finish;
    }

    /**
     * 设置是否完成
     *
     * @param finish 是否完成
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
     * 获取每天总结
     *
     * @return summary - 每天总结
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置每天总结
     *
     * @param summary 每天总结
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}