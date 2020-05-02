package crw.bishe.team.controller.project;

import crw.bishe.team.dto.MyTaskDto;
import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.dto.TaskListDto;
import crw.bishe.team.service.TaskService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/20
 * @Time 0:17
 **/
@Api(tags = {"任务管理"})
@RestController
@Log4j2
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @ApiOperation(value = "查找所有任务信息")
    @GetMapping("/all")
    public ResponseEntity<Result<List<TaskDto>>> findAll(){
        try{
            List<TaskDto> taskDtos = taskService.findAll();
            return new ResponseEntity<>(new Result(200, "处理成功", taskDtos), HttpStatus.OK);
        }catch (Exception e){
            log.info(e.toString());
            return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "新增任务信息")
    @PostMapping("")
    public ResponseEntity<Result> create(@ApiParam(value = "项目信息") @RequestBody @Validated TaskDto taskDto){
        TaskDto res = taskService.create(taskDto);
        if(res != null){
            return new ResponseEntity<>(new Result(200, "处理成功", res), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "修改任务信息")
    @PutMapping("/{id}")
    public ResponseEntity<Result> update(@ApiParam(value = "项目ID") @PathVariable(name = "id") String id ,
                                         @ApiParam(value = "项目信息") @RequestBody @Validated TaskDto taskDto){
        int res = taskService.update(taskDto, id);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "删除任务信息")
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@ApiParam(value = "项目ID") @PathVariable(name = "id") String id){
        int res = taskService.delete(id);
        if(res > 0){
            return new ResponseEntity<>(new Result(200, "处理成功"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result("处理失败"), HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "根据用户ID获取任务信息")
    @GetMapping("/getTaskByUserId/{userId}")
    public ResponseEntity<Result> getTaskByUserId(@ApiParam(value = "用户ID") @PathVariable(name = "userId") String user_id){
        List<TaskDto> taskDtos = taskService.getTaskByUserId(user_id);
        return new ResponseEntity<>(new Result(200, "根据用户ID获取任务信息", taskDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "根据项目ID查找项目对应的任务信息")
    @GetMapping("/getTaskList/{id}")
    public ResponseEntity<Result> getTaskList(@PathVariable(name = "id" ) String proId){
        List<TaskListDto> taskListDtos = taskService.getTaskList(proId);
        return new ResponseEntity<>(new Result<>(200,"处理成功", taskListDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "根据项目ID获取所有任务信息以及子任务信息")
    @GetMapping("/geTaskByProId/{proId}")
    public ResponseEntity<Result> geTaskByProId(@PathVariable(name = "proId") String proId){
        List<TaskDto> taskDtos = taskService.geTaskByProId(proId);
        return new ResponseEntity<>(new Result(200,"OK", taskDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "根据任务id更新任务状态信息")
    @GetMapping("/updateTaskByTaskId/{taskId}")
    public ResponseEntity<Result> updateTaskByTaskId(@PathVariable(name = "taskId") String taskId){
        Integer res = taskService.updateTaskByTaskId(taskId);
        return new ResponseEntity<>(new Result(200, "OK", res), HttpStatus.OK);
    }

}
