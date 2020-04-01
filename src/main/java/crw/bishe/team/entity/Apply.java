package crw.bishe.team.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "apply")
public class Apply {
    /**
     * ID
     */
    @Id
    @Column(name = "apply_id")
    private Long applyId;

    /**
     * 团队ID号
     */
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 团队名称
     */
    @Column(name = "team_name")
    private String teamName;

    /**
     * 申请人ID号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 申请人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 申请时间
     */
    @Column(name = "apply_date")
    private Date applyDate;

    /**
     * 申请描述
     */
    private String decribe;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 申请状态
     */
    private Byte status;

}