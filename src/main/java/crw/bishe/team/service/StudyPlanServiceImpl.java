package crw.bishe.team.service;

import crw.bishe.team.dto.StudyPlanDto;
import crw.bishe.team.dtoEntityMapping.StudyPlanMapping;
import crw.bishe.team.entity.StudyPlan;
import crw.bishe.team.mapper.StudyPlanMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudyPlanServiceImpl implements StudyPlanService {

    @Autowired
    private StudyPlanMapper studyPlanMapper;

    @Autowired
    private StudyPlanMapping studyPlanMapping;

    @Override
    public List<StudyPlanDto> getStudyPlans(String userId) {
        Long key = Long.parseLong(userId);
        List<StudyPlanDto> list = studyPlanMapper.getStudyPlans(key);
        // 按时间排序
        Collections.sort(list, new Comparator<StudyPlanDto>() {
            @Override
            public int compare(StudyPlanDto o1, StudyPlanDto o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    if (format.parse(o1.getSpTime()).getTime() > format.parse(o2.getSpTime()).getTime()){
                        return -1;
                    }else if (format.parse(o1.getSpTime()).getTime() < format.parse(o2.getSpTime()).getTime()){
                        return 1;
                    }else{
                        return 0;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        return list;
    }

    @Override
    public StudyPlanDto insertStudyPlan(StudyPlanDto studyPlanDto) {
        // 将dto转为entity
        StudyPlan studyPlan = studyPlanMapping.toEntity(studyPlanDto);
        Integer res = studyPlanMapper.insertStudyPlan(studyPlan);
        return studyPlanMapping.toDto(studyPlan);
    }
}
