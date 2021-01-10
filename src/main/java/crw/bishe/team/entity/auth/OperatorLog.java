package crw.bishe.team.entity.auth;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  
 * </p>
 *
 * @author caorongwu
 * @since 2021-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OPERATOR_LOG")
@ApiModel(value="OperatorLog对象", description=" ")
public class OperatorLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Integer revision;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATED_BY")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "更新人")
    @TableField("UPDATED_BY")
    private String updatedBy;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "日志ID")
    @TableId("LOG_ID")
    private String logId;

    @ApiModelProperty(value = "操作人")
    @TableField("OPERATOR_USER")
    private String operatorUser;

    @ApiModelProperty(value = "操作时间")
    @TableField("OPERATOR_TIME")
    private String operatorTime;

    @ApiModelProperty(value = "操作类型")
    @TableField("OPERATOR_TYPE")
    private String operatorType;

    @ApiModelProperty(value = "操作描述")
    @TableField("OPERATOR_DESC")
    private String operatorDesc;


}
