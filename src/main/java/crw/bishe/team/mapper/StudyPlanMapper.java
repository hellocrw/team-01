package crw.bishe.team.mapper;

import crw.bishe.team.dto.StudyPlanDto;
import crw.bishe.team.entity.StudyPlan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StudyPlanMapper extends Mapper<StudyPlan> {

    /**
     * 获取学习计划信息
     * @param userId
     * @return
     */
    @Select("SELECT * FROM study_plan WHERE study_plan.`user_id` = #{userId}")
    List<StudyPlanDto> getStudyPlans(Long userId);

    /**
     * 增加学习计划
     * @param studyPlan
     * @return
     */
    @Insert("INSERT INTO study_plan VALUE (NULL, #{userId}, #{spTitle}, #{spContext},#{spTime}, #{spLink})")
    @Options(useGeneratedKeys = true, keyProperty = "spId", keyColumn = "sp_id")
    Integer insertStudyPlan(StudyPlan studyPlan);
}