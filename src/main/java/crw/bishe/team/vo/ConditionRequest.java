package crw.bishe.team.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description Description 查询条件请求参数
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 23:57
 */
@Data
@ApiModel(value = "查询条件请求参数")
public class ConditionRequest {
    @ApiModelProperty(position = 1, value = "项目ID")
    private String proId;
    @ApiModelProperty(position = 2, value = "学校")
    private String university;
    @ApiModelProperty(position = 3, value = "项目类型")
    private String proType;
    @ApiModelProperty(position = 4, value = "关键字查询")
    private String key;
}
