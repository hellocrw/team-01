package crw.bishe.team.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel("用户注册DTO")
public class UserRegisterDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String role;
    private String userGroupId;
}
