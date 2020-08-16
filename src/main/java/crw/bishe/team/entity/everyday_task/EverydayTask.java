package crw.bishe.team.entity.everyday_task;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author caorongwu
 * @since 2020-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EverydayTask对象", description="")
public class EverydayTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID号")
    @TableId(value = "everyday_task_id", type = IdType.AUTO)
    private Long everydayTaskId;

    @ApiModelProperty(value = "每天任务内容")
    private String content;

    @ApiModelProperty(value = "是否完成任务，“0”未完成，“1”已完成")
    private Integer finish;

    @ApiModelProperty(value = "打卡时间")
    private Date clockTime;

    @ApiModelProperty(value = "创建人ID号")
    private Long userId;

    private String summary;


}
