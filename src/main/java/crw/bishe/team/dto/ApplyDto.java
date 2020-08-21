package crw.bishe.team.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 0:31
 */
@ApiModel(value = "申请表信息")
@Data
public class ApplyDto implements Serializable {

    @ApiModelProperty(position = 1, value = "申请ID")
    private String applyId;

    @ApiModelProperty(position = 2, value = "团队ID号")
    private String teamId;

    private String teamName;

    @ApiModelProperty(position = 3, value = "申请人ID号")
    private String userId;

    @ApiModelProperty(position = 4, value = "申请人")
    private String userName;

    @ApiModelProperty(position = 5, value = "申请时间")
    private String applyDate;

    @ApiModelProperty(position = 6, value = "申请描述")
    private String decribe;

    @ApiModelProperty(position = 7, value = "联系方式")
    private String phone;

    @ApiModelProperty(position = 8, value = "申请状态")
    private String status;
}
