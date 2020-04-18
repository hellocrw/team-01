package crw.bishe.team.controller.project;

import crw.bishe.team.service.TeamTypeService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = {"团队类型管理"})
@RestController
@RequestMapping("/api/team_type")
@Log4j2
public class TeamTypeController {

    @Autowired
    private TeamTypeService teamTypeService;

    @ApiOperation(value = "通过userId获取团队分析")
    @GetMapping("/getTeamTypeNumber/{userId}")
    public ResponseEntity<Result> getTeamTypeNumber(@PathVariable(name = "userId") String userId){
        List<Map<String , Object>> mapList = teamTypeService.getTeamTypeNumber(userId);
        return new ResponseEntity<>(new Result(200, "OK", mapList), HttpStatus.OK);
    }

    @ApiOperation(value = "通过userId获取项目分析")
    @GetMapping("/getProTypeNumber/{userId}")
    public ResponseEntity<Result> getProTypeNumber(@PathVariable(name = "userId") String userId){
        List<Map<String , Object>> mapList = teamTypeService.getProTypeNumber(userId);
        return new ResponseEntity<>(new Result(200, "OK", mapList), HttpStatus.OK);
    }

    @ApiOperation(value = "通过userId获取任务分析")
    @GetMapping("/getTaskTypeNumber/{userId}")
    public ResponseEntity<Result> getTaskTypeNumber(@PathVariable(name = "userId") String userId){
        List<Map<String , Object>> mapList = teamTypeService.getTaskTypeNumber(userId);
        return new ResponseEntity<>(new Result(200, "OK", mapList), HttpStatus.OK);
    }

}
