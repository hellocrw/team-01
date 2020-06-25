package crw.bishe.team.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "study_plan")
public class StudyPlan {
    @Id
    @Column(name = "sp_id")
    private Integer spId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "sp_title")
    private String spTitle;

    @Column(name = "sp_context")
    private String spContext;

    @Column(name = "sp_time")
    private Date spTime;

    @Column(name = "sp_link")
    private String spLink;

    /**
     * @return sp_id
     */
    public Integer getSpId() {
        return spId;
    }

    /**
     * @param spId
     */
    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return sp_title
     */
    public String getSpTitle() {
        return spTitle;
    }

    /**
     * @param spTitle
     */
    public void setSpTitle(String spTitle) {
        this.spTitle = spTitle == null ? null : spTitle.trim();
    }

    /**
     * @return sp_context
     */
    public String getSpContext() {
        return spContext;
    }

    /**
     * @param spContext
     */
    public void setSpContext(String spContext) {
        this.spContext = spContext == null ? null : spContext.trim();
    }

    /**
     * @return sp_time
     */
    public Date getSpTime() {
        return spTime;
    }

    /**
     * @param spTime
     */
    public void setSpTime(Date spTime) {
        this.spTime = spTime;
    }

    /**
     * @return sp_link
     */
    public String getSpLink() {
        return spLink;
    }

    /**
     * @param spLink
     */
    public void setSpLink(String spLink) {
        this.spLink = spLink == null ? null : spLink.trim();
    }
}