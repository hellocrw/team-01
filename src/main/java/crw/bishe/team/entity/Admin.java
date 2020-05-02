package crw.bishe.team.entity;

import javax.persistence.*;

@Table(name = "admin")
public class Admin {
    /**
     * 管理员ID
     */
    @Id
    @Column(name = "admin_id")
    private Long adminId;

    /**
     * 管理员名字
     */
    @Column(name = "admin_name")
    private String adminName;

    /**
     * 获取管理员ID
     *
     * @return admin_id - 管理员ID
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 设置管理员ID
     *
     * @param adminId 管理员ID
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取管理员名字
     *
     * @return admin_name - 管理员名字
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员名字
     *
     * @param adminName 管理员名字
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}