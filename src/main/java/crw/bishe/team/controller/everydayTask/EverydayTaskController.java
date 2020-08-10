package crw.bishe.team.controller.everydayTask;

import crw.bishe.team.entity.EverydayTask;
import crw.bishe.team.service.EverydayTaskService;
import crw.bishe.team.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/everyday-task")
public class EverydayTaskController {
    @Resource
    private EverydayTaskService everydayTaskService;

    @GetMapping("/query/{userId}")
    public ResponseEntity<Result> queryEverydayTask(@PathVariable("userId") String userId){
        List<EverydayTask> res = everydayTaskService.qureyEverydayTask(userId);
        for (EverydayTask everydayTask: res
             ) {
            System.out.println(everydayTask.toString());
        }
        return new ResponseEntity<>(new Result<>(200, "success", res) , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Result> createEverydayTask(@RequestBody EverydayTask everydayTask){
        Integer res = everydayTaskService.createEverydayTask(everydayTask);
        return res == 1 ? new ResponseEntity<>(new Result(200, "success", res) ,HttpStatus.OK): new ResponseEntity<>(new Result(500, "fault"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/clock/{userId}/{everydayTaskId}")
    public ResponseEntity<Result> clock(@PathVariable("userId") String userId, @PathVariable("everydayTaskId") String everydayTaskId){
        Integer res = everydayTaskService.clock(userId, everydayTaskId);
        return res >= 1 ? new ResponseEntity<>(new Result(200, "success", res), HttpStatus.OK): new ResponseEntity<>(new Result(500, "fault"), HttpStatus.BAD_REQUEST);
    }

}
