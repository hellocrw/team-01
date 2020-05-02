package crw.bishe.team.controller.project;

import crw.bishe.team.dto.SubTaskDto;
import crw.bishe.team.service.SubTaskService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = {"子任务管理"})
@Controller
@RequestMapping("/api/sub-task")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @ResponseBody
    @DeleteMapping("")
    public ResponseEntity<Result> deleteByTaskIds(@RequestBody List<String> taskIds){
        Integer res = subTaskService.deleteByTaskIds(taskIds);
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Result> selectByTaskId(@RequestParam("taskIds[]") List<String> taskIds){
        List<SubTaskDto> res = subTaskService.selectByTaskIds(taskIds);
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }
}
