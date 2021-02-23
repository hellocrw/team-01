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
 * 标签表
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BolgLabel对象", description="标签表")
public class BolgLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签编号")
    @TableId(value = "label_id", type = IdType.AUTO)
    private Integer labelId;

    @ApiModelProperty(value = "标签名称")
    private String labelName;

    @ApiModelProperty(value = "标签别名")
    private String labelAlias;

    @ApiModelProperty(value = "标签描述")
    private String labelDescription;


}
