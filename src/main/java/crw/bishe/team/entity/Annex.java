package crw.bishe.team.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "annex")
public class Annex {
    /**
     * ID
     */
    @Id
    @Column(name = "annex_id")
    private Long annexId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 附件链接
     */
    private String link;

    /**
     * 创建时间
     */
    private Date createTime;
}