package crw.bishe.team.entity.naire;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author caorongwu
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("QUESTION_NAIRE")
@ApiModel(value="QuestionNaire对象", description="")
public class QuestionNaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @Id
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "填写时间")
    private String createTime;

    @ApiModelProperty(value = "是否参加：0表示否，1表示是")
    private String isJoin;

    @ApiModelProperty(value = "初三到初四 ，初四到初五 ， 都行")
    private String joinTime;

    @ApiModelProperty(value = "何坚村，其他")
    private String place;

    @ApiModelProperty(value = "活动内容")
    private String activeContent;

    @ApiModelProperty(value = "活动建议")
    private String activeProsal;

}
