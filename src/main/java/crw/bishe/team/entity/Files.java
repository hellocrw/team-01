package crw.bishe.team.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "files")
public class Files {
    /**
     * 文件ID
     */
    @Id
    @Column(name = "file_id")
    private Long fileId;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 文件链接
     */
    @Column(name = "file_link")
    private String fileLink;

    /**
     * 项目id
     */
    @Column(name = "pro_id")
    private Long proId;

    /**
     * 上传时间
     */
    @Column(name = "upload_time")
    private Date uploadTime;

    /**
     * 获取文件ID
     *
     * @return file_id - 文件ID
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * 设置文件ID
     *
     * @param fileId 文件ID
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取文件名
     *
     * @return file_name - 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文件名
     *
     * @param fileName 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取文件链接
     *
     * @return file_link - 文件链接
     */
    public String getFileLink() {
        return fileLink;
    }

    /**
     * 设置文件链接
     *
     * @param fileLink 文件链接
     */
    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    /**
     * 获取项目id
     *
     * @return pro_id - 项目id
     */
    public Long getProId() {
        return proId;
    }

    /**
     * 设置项目id
     *
     * @param proId 项目id
     */
    public void setProId(Long proId) {
        this.proId = proId;
    }

    /**
     * 获取上传时间
     *
     * @return upload_time - 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 设置上传时间
     *
     * @param uploadTime 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}