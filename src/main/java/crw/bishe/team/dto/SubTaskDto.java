package crw.bishe.team.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/3/15 0015
 * @Time 3:00
 */
@Data
@ApiModel(value = "子任务信息")
public class SubTaskDto {

    private String id;

    private String subTaskId;

    private String subTaskContent;

    private String subTaskCharger;

    private String subTaskStatus;

}
