package crw.bishe.team.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "notice")
public class Notice {
    /**
     * 公告id
     */
    @Id
    @Column(name = "notice_id")
    private Long noticeId;

    /**
     * 发布者id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 发布者姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 项目id
     */
    @Column(name = "pro_id")
    private Long proId;

    /**
     * 项目名称
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 公告内容
     */
    @Column(name = "notice_content")
    private String noticeContent;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态
     */
    @Column(name = "status")
    private Byte status;
}