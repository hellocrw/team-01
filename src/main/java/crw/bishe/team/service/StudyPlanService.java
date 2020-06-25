package crw.bishe.team.service;

import crw.bishe.team.dto.StudyPlanDto;
import crw.bishe.team.entity.StudyPlan;

import java.util.List;

public interface StudyPlanService {

    List<StudyPlanDto> getStudyPlans(String userId);

    StudyPlanDto insertStudyPlan(StudyPlanDto studyPlanDto);
}
