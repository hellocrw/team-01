package crw.bishe.team.entity.auth;

import com.baomidou.mybatisplus.annotation.KeySequence;
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
@TableName("AUTH_ROLE")
@ApiModel(value="AuthRole对象", description=" ")
@KeySequence(value = "RECORD_SEQ", clazz = String.class)
public class AuthRole implements Serializable {

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

    @ApiModelProperty(value = "角色ID")
    @TableId("ROLE_ID")
    private String roleId;

    @ApiModelProperty(value = "角色名称")
    @TableField("ROLE_NAME")
    private String roleName;


}