package crw.bishe.team.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/19
 * @Time 22:53
 **/
@ApiModel(description = "任务信息")
@Data
@ToString(callSuper = true)
public class MyTaskDto {

    @ApiModelProperty(position = 2, value = "任务ID", required = true)
    private String taskId;

    @ApiModelProperty(position = 6, value = "任务开始时间")
    private String taskStartTime;

    @ApiModelProperty(position = 7, value = "任务结束时间")
    private String taskEndTime;

    @ApiModelProperty(position = 8, value = "任务内容")
    private String taskContent;

    @ApiModelProperty(position = 10, value = "任务状态")
    private String taskStatus;
}
