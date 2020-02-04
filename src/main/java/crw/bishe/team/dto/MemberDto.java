package crw.bishe.team.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 14:54
 */
@Data
@ApiModel(value = "团队成员信息")
public class MemberDto {
    @ApiModelProperty(position = 1, value = "用户ID")
    private String UserId;
    @ApiModelProperty(position = 2, value = "团队ID")
    private String TeamId;
    @ApiModelProperty(position = 3, value = "团队用户关联ID")
    private String UtId;
    @ApiModelProperty(position = 4, value = "用户名字")
    private String UserName;

}
