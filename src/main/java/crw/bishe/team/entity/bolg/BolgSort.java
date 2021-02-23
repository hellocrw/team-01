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
 * 分类表
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BolgSort对象", description="分类表")
public class BolgSort implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类编号")
    @TableId(value = "sort_id", type = IdType.AUTO)
    private Integer sortId;

    @ApiModelProperty(value = "分类名称")
    private String sortName;

    @ApiModelProperty(value = "分类别名")
    private String sortAlias;

    @ApiModelProperty(value = "分类描述")
    private String sortDescription;

    @ApiModelProperty(value = "父级分类编号")
    private Integer parentSortId;


}
