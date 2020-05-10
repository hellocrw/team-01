package crw.bishe.team.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "dictionary")
public class Dictionary implements Serializable {
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