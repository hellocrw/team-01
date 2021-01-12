package crw.bishe.team.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AlterPasswordDto {
    private String username;
    private String role;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
