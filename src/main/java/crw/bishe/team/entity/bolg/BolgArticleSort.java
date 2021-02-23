package crw.bishe.team.entity.bolg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客分类关联表
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BolgArticleSort对象", description="博客分类关联表")
public class BolgArticleSort implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客分类关联编号")
    @TableId(value = "article_sort_id", type = IdType.AUTO)
    private Integer articleSortId;

    @ApiModelProperty(value = "博客编号")
    private Integer articleId;

    @ApiModelProperty(value = "分类编号")
    private Integer sortId;


}
