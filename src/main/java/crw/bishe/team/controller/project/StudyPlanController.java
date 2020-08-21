package crw.bishe.team.controller.project;

import crw.bishe.team.dto.StudyPlanDto;
import crw.bishe.team.entity.StudyPlan;
import crw.bishe.team.service.StudyPlanService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"学习计划"})
@RestController
@RequestMapping("/api/study-plan")
@Log4j2
public class StudyPlanController {

    @Autowired
    private StudyPlanService studyPlanService;

    @ApiOperation(value = "获取学习计划")
    @GetMapping("/getStudyPlans/{userId}")
    public ResponseEntity<Result> getStudyPlans(@PathVariable(name = "userId") String userId){
        List<StudyPlanDto> list = studyPlanService.getStudyPlans(userId);
        return new ResponseEntity<>(new Result(200, "OK", list), HttpStatus.OK);
    }

    @ApiOperation(value = "增加学习计划")
    @PostMapping("/insertStudyPlan")
    public ResponseEntity<Result> insertStudyPlan(@RequestBody StudyPlanDto studyPlanDto){
        StudyPlanDto res = studyPlanService.insertStudyPlan(studyPlanDto);
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }
}
