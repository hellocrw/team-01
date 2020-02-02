package crw.bishe.team.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 2:21
 */
@Data
@ApiModel("用户权限信息")
@ToString(callSuper = true)
public class UserRolesDto {

    @ApiModelProperty(position = 2, value = "用户ID", required = true)
    private String id;

    @ApiModelProperty(position = 2, value = "用户名", required = true)
    private String username;

    @ApiModelProperty(position = 2, value = "密码", required = true)
    private String password;

    @ApiModelProperty(position = 2, value = "权限", required = true)
    private String auth;
}
