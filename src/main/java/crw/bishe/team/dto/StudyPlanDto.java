package crw.bishe.team.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "学习计划")
public class StudyPlanDto {
    private String spId;
    private String userId;
    private String spTitle;
    private String spContext;
    private String spTime;
    private String spLink;
}
