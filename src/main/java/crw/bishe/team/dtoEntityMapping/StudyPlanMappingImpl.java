package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.StudyPlanDto;
import crw.bishe.team.entity.StudyPlan;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("studyPlanMapping")
public class StudyPlanMappingImpl implements StudyPlanMapping {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public StudyPlan toEntity(StudyPlanDto studyPlanDto) {
        if (studyPlanDto == null ){
            return null;
        }
        StudyPlan studyPlan = new StudyPlan();
        if (studyPlanDto.getSpId() == "" || studyPlanDto.getSpId() == null){
            studyPlan.setSpId(null);
            if (studyPlanDto.getSpContext() != null)
                studyPlan.setSpContext(studyPlanDto.getSpContext());
            if (studyPlanDto.getSpLink() != null)
                studyPlan.setSpLink(studyPlanDto.getSpLink());
            if (studyPlanDto.getSpTitle() != null)
                studyPlan.setSpTitle(studyPlanDto.getSpTitle());
            if (studyPlanDto.getSpTime() != null) {
                try {
                    System.out.println(studyPlanDto.getSpTime());
                    System.out.println(new Date());
                    Date date = simpleDateFormat.parse(studyPlanDto.getSpTime());
                    System.out.println("date------------" + date);
                    studyPlan.setSpTime(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
//                simpleDateFormat.format(Date.valueOf(studyPlanDto.getSpTime()).getTime());
//                studyPlan.setSpTime(Date.valueOf(studyPlanDto.getSpTime()));
            if (studyPlanDto.getUserId() != null)
                studyPlan.setUserId(Long.parseLong(studyPlanDto.getUserId()));
        }
        return studyPlan;
    }

    @Override
    public StudyPlanDto toDto(StudyPlan studyPlan) {
        if (studyPlan == null){
            return null;
        }
        StudyPlanDto studyPlanDto = new StudyPlanDto();
        studyPlanDto.setSpId(String.valueOf(studyPlan.getSpId()));
        studyPlanDto.setSpTitle(studyPlan.getSpTitle());
        studyPlanDto.setSpContext(studyPlan.getSpContext());
        studyPlanDto.setUserId(String.valueOf(studyPlan.getUserId()));
        studyPlanDto.setSpLink(studyPlan.getSpLink());
        studyPlanDto.setSpTime(simpleDateFormat.format(studyPlan.getSpTime()));
        return studyPlanDto;
    }
}
