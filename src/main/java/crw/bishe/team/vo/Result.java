package crw.bishe.team.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description 结果格式
 * @Author crw
 * @Date Created in 2020/1/10 0010
 * @Time 21:43
 */
@Data
@ApiModel(value = "返回数据格式")
public class Result<T> {
    @ApiModelProperty(position = 1, value = "状态码")
    private int status;
    @ApiModelProperty(position = 2, value = "信息描述")
    private String desc;
    @ApiModelProperty(position = 3, value = "数据")
    private T data;

    public Result(){}

    public Result(String desc) {
        this.desc = desc;
    }

    public Result(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Result(int status, String desc, T data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

}
