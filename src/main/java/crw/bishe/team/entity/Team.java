package crw.bishe.team.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "team")
@Data
public class Team {
    /**
     * ID
     */
    @Id
    @Column(name = "team_id")
    private Long teamId;

    /**
     * 团队名称
     */
    @Column(name = "team_name")
    private String teamName;
    /**
     * 管理员ID
     */
    @Column(name = "admin_id")
    private Long adminId;

    /**
     * 队长ID
     */
    @Column(name = "leader_id")
    private Long leaderId;

    @Column(name = "leader_name")
    private String LeaderName;

    /**
     * 团队描述
     */
    @Column(name = "team_describe")
    private String teamDescribe;

    /**
     * 团队类型
     */
    @Column(name = "team_type")
    private String teamType;

    /**
     * 团队范围
     */
    @Column(name = "team_scope")
    private String teamScope;

    /**
     * 团队人数
     */
    @Column(name = "team_number")
    private Integer teamNumber;

    @Column(name = "sum_number")
    private Integer sumNumber;

    /**
     * 团队创建日期
     */
    @Column(name = "team_date")
    private Date teamDate;

    /**
     * 团队状态
     */
    private Integer status;

    /**
     * 人员类型
     */
    private String staff;

    /**
     * 性质
     */
    private String teamNature;

    /**
     * 团队标签
     */
    private String teamLabel;

    /**
     * 查看人数
     */
    private Integer seeNum;

    /**
     * 项目
     */
    private List<Project> projects;
}