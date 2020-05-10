package crw.bishe.team.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 22:11
 */
@Data
public class TaskListDto implements Serializable {
    private String taskId;
    private String taskStartTime;
    private String taskEndTime;
    private String taskContent;
    private String taskCharger;
    private String subTaskId;
    private String taskStatus;
}
