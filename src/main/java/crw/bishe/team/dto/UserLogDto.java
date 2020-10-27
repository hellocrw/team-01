package crw.bishe.team.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 定义用户发送的日志数据
 */
@Data
@Builder
@Accessors(chain = true)
public class UserLogDto {
    private String username;

    private String userid;

    private String state;
}
