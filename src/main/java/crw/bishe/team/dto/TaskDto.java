package crw.bishe.team.dto;

import crw.bishe.team.entity.SubTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/19
 * @Time 22:53
 **/
@ApiModel(description = "任务信息")
@Data
@ToString(callSuper = true)
public class TaskDto {

    @ApiModelProperty(position = 2, value = "任务ID", required = true)
    private String taskId;

    @ApiModelProperty(position = 3, value = "团队ID")
    private String teamId;

    @ApiModelProperty(position = 4, value = "项目ID")
    private String proId;

    @ApiModelProperty(position = 5, value = "任务创建时间")
    private String taskCreateTime;

    @ApiModelProperty(position = 6, value = "任务开始时间")
    private String taskStartTime;

    @ApiModelProperty(position = 7, value = "任务结束时间")
    private String taskEndTime;

    @ApiModelProperty(position = 7, value = "任务内容")
    private String taskContent;

    @ApiModelProperty(position = 8, value = "任务负责人ID")
    private String userId;

    @ApiModelProperty(position = 9, value = "子任务ID")
    private String subTaskId;

    @ApiModelProperty(position = 10, value = "任务状态")
    private String taskStatus;

    @ApiModelProperty(position = 11, value = "备注")
    private String taskMark;

    @ApiModelProperty(position = 12, value = "子任务信息")
    private List<SubTaskDto> subTaskDtos;
}
