package crw.bishe.team.entity.bolg;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客表
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BolgArticle对象", description="博客表")
public class BolgArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客编号")
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    @ApiModelProperty(value = "博客标题")
    private String articleTitle;

    @ApiModelProperty(value = "博客内容")
    private String articleContent;

    @ApiModelProperty(value = "博客访问量")
    private Integer articleViews;

    @ApiModelProperty(value = "评论总数")
    private Integer articleCommentCount;

    @ApiModelProperty(value = "博客发表时间")
    private Date articleCreateDate;

    @ApiModelProperty(value = "博客点赞数")
    private Integer articleLikeCount;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "最新更新时间")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "博客图片")
    private String articleImage;


}
