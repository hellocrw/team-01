package crw.bishe.team.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "log")
public class Log implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "log_id")
    private Long logId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 操作类型
     */
    private String type;

    /**
     * 操作时间
     */
    private Date time;

    /**
     * 操作结果
     */
    private String result;

}