package crw.bishe.team.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "task")
@Data
public class Task {
    /**
     * ID
     */
    @Id
    @Column(name = "task_id")
    private Long taskId;

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
    private Integer taskStatus;

    /**
     * 备注
     */
    @Column(name = "task_mark")
    private String taskMark;
}