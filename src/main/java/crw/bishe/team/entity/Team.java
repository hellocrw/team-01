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
     * 队长ID
     */
    @Column(name = "leader_id")
    private Long leaderId;

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
     * 团队人数
     */
    @Column(name = "team_number")
    private Integer teamNumber;

    /**
     * 团队创建日期
     */
    @Column(name = "team_date")
    private Date teamDate;

    /**
     * 团队状态
     */
    private Byte status;

    /**
     * 人员类型
     */
    private String staff;

    /**
     * 项目
     */
    private List<Project> projects;
}