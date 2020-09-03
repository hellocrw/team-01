package crw.bishe.team.controller.everydayTask;

import crw.bishe.team.entity.EverydayTask;
import crw.bishe.team.service.EverydayTaskService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = {"每天任务管理器"})
@RestController
@RequestMapping("/api/everyday-task")
public class EverydayTaskController {
    @Resource
    private EverydayTaskService everydayTaskService;

    /**
     *  查询所有的每天任务
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/query/{userId}")
    public ResponseEntity<Result> queryEverydayTask(@PathVariable("userId") String userId){
        List<EverydayTask> res = everydayTaskService.qureyEverydayTask(userId);
        return new ResponseEntity<>(new Result<>(200, "success", res) , HttpStatus.OK);
    }

    /**
     * 创建每天任务
     * @param everydayTask
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<Result> createEverydayTask(@RequestBody EverydayTask everydayTask){
        Integer res = everydayTaskService.createEverydayTask(everydayTask);
        return res == 1 ? new ResponseEntity<>(new Result(200, "success", res) ,HttpStatus.OK): new ResponseEntity<>(new Result(500, "fault"), HttpStatus.BAD_REQUEST);
    }

    /**
     * 打卡
     * @param userId 用户ID
     * @param everydayTaskId 每天任务ID
     * @return
     */
    @GetMapping("/clock/{userId}/{everydayTaskId}")
    public ResponseEntity<Result> clock(@PathVariable("userId") String userId, @PathVariable("everydayTaskId") String everydayTaskId){
        Integer res = everydayTaskService.clock(userId, everydayTaskId);
        return res >= 1 ? new ResponseEntity<>(new Result(200, "success", res), HttpStatus.OK): new ResponseEntity<>(new Result(500, "fault"), HttpStatus.BAD_REQUEST);
    }

    /**
     * 删除每天任务
     * @param everydayTaskId 每天任务ID
     * @return
     */
    @DeleteMapping("/delete/{everydayTaskId}")
    public ResponseEntity<Result> deleteByEverydayTaskId(@PathVariable("everydayTaskId") String everydayTaskId){
        Integer res = everydayTaskService.deleteTask(everydayTaskId);
        return res >= 1 ? new ResponseEntity<>(new Result(200, "success", res), HttpStatus.OK): new ResponseEntity<>(new Result(500, "fault"), HttpStatus.BAD_REQUEST);
    }
}