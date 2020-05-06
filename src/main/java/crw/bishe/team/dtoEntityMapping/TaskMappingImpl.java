package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.MyTaskDto;
import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.entity.Task;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/19
 * @Time 23:02
 **/
@Component("taskMapping")
public class TaskMappingImpl implements TaskMapping {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Task toEntity(TaskDto taskDto) {
        if (taskDto == null) {
            return null;
        }
        Task task = new Task();
        if(taskDto.getTaskId() == null || taskDto.getTaskId() == ""){
            task.setTaskId(null);
        }else{
            task.setTaskId(Long.parseLong(taskDto.getTaskId()));
        }
        if (taskDto.getProId() != null)
            task.setProId(Long.parseLong(taskDto.getProId()));
        if (taskDto.getTaskCreateTime() != null)
            task.setTaskCreateTime(Date.valueOf(taskDto.getTaskCreateTime()));
        if (taskDto.getTaskStartTime() != null)
            task.setTaskStartTime(Date.valueOf(taskDto.getTaskStartTime()));
        if (taskDto.getTaskEndTime() != null)
            task.setTaskEndTime(Date.valueOf(taskDto.getTaskEndTime()));
        if (taskDto.getTaskContent() != null)
            task.setTaskContent(taskDto.getTaskContent());
        if (taskDto.getUserId() != null)
            task.setUserId(Long.parseLong(taskDto.getUserId()));
        if ((taskDto.getUserName() != null))
            task.setUserName(taskDto.getUserName());
        if (taskDto.getTaskStatus() != null)
            task.setTaskStatus(Integer.parseInt(taskDto.getTaskStatus()));
        if (taskDto.getTaskMark() != null)
            task.setTaskMark(taskDto.getTaskMark());
        return task;
    }

    @Override
    public TaskDto toDto(Task task) {
        if(task == null){
            return null;
        }
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(String.valueOf(task.getTaskId()));
        taskDto.setProId(String.valueOf(task.getProId()));
        taskDto.setTaskCreateTime(simpleDateFormat.format(task.getTaskCreateTime()));
        taskDto.setTaskStartTime(simpleDateFormat.format(task.getTaskStartTime()));
        taskDto.setTaskEndTime(simpleDateFormat.format(task.getTaskEndTime()));
        taskDto.setTaskContent(task.getTaskContent());
        taskDto.setUserId(String.valueOf(task.getUserId()));
        taskDto.setUserName(task.getUserName());
        taskDto.setTaskStatus(String.valueOf(task.getTaskStatus()));
        taskDto.setTaskMark(task.getTaskMark());
        return taskDto;
    }

    @Override
    public MyTaskDto toMyTaskDto(Task task) {
        if (task == null){
            return null;
        }
        MyTaskDto myTaskDto = new MyTaskDto();
        myTaskDto.setTaskId(String.valueOf(task.getTaskId()));
        myTaskDto.setTaskStartTime(simpleDateFormat.format(task.getTaskStartTime()));
        myTaskDto.setTaskEndTime(simpleDateFormat.format(task.getTaskEndTime()));
        myTaskDto.setTaskContent(task.getTaskContent());
        myTaskDto.setTaskStatus(String.valueOf(task.getTaskStatus()));
        return myTaskDto;
    }
}
