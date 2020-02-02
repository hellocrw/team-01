package crw.bishe.team.entity;

import javax.persistence.*;

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

    /**
     * 获取字典ID
     *
     * @return dict_id - 字典ID
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * 设置字典ID
     *
     * @param dictId 字典ID
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取项目类型
     *
     * @return pro_type - 项目类型
     */
    public String getProType() {
        return proType;
    }

    /**
     * 设置项目类型
     *
     * @param proType 项目类型
     */
    public void setProType(String proType) {
        this.proType = proType;
    }

    /**
     * 获取学校
     *
     * @return university - 学校
     */
    public String getUniversity() {
        return university;
    }

    /**
     * 设置学校
     *
     * @param university 学校
     */
    public void setUniversity(String university) {
        this.university = university;
    }
}