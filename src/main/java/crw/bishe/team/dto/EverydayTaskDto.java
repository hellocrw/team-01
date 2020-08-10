package crw.bishe.team.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EverydayTaskDto {
    public String everydayTaskId;
    public String content;
    public String finish;
    public String clockTime;
    public String userId;
}
