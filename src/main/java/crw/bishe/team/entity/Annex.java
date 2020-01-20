package crw.bishe.team.entity;

import javax.persistence.*;

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
     * 附件链接
     */
    private String link;

    /**
     * 获取ID
     *
     * @return annex_id - ID
     */
    public Long getAnnexId() {
        return annexId;
    }

    /**
     * 设置ID
     *
     * @param annexId ID
     */
    public void setAnnexId(Long annexId) {
        this.annexId = annexId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取附件链接
     *
     * @return link - 附件链接
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置附件链接
     *
     * @param link 附件链接
     */
    public void setLink(String link) {
        this.link = link;
    }
}