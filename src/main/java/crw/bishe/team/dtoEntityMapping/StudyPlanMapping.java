package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.StudyPlanDto;
import crw.bishe.team.entity.StudyPlan;

public interface StudyPlanMapping {

    StudyPlan toEntity(StudyPlanDto studyPlanDto);

    StudyPlanDto toDto(StudyPlan studyPlan);
}
