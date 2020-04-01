package crw.bishe.team.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "dictionary")
public class Dictionary {
    /**
     * 字典ID
     */
    @Id
    @Column(name = "dict_id")
    private Long dictId;

    /**
     * 项目类型
     */
    @Column(name = "pro_type")
    private String proType;

    /**
     * 学校
     */
    private String university;
}