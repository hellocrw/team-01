package crw.bishe.team.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
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

    @Column(name = "pro_name")
    private String proName;

    /**
     * 上传时间
     */
    @Column(name = "upload_time")
    private Date uploadTime;
}