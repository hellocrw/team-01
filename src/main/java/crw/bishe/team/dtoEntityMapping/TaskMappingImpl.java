package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.MyTaskDto;
import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.entity.Task;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.sql.Date;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/19
 * @Time 23:02
 **/
@Component("taskMapping")
public class TaskMappingImpl implements TaskMapping {
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
        task.setTeamId(Long.parseLong(taskDto.getTeamId()));
        task.setProId(Long.parseLong(taskDto.getProId()));
        task.setTaskCreateTime(Date.valueOf(taskDto.getTaskCreateTime()));
        task.setTaskStartTime(Date.valueOf(taskDto.getTaskStartTime()));
        task.setTaskEndTime(Date.valueOf(taskDto.getTaskEndTime()));
        task.setTaskContent(taskDto.getTaskContent());
        task.setUserId(Long.parseLong(taskDto.getUserId()));
        task.setSubTaskId(Long.parseLong(taskDto.getSubTaskId()));
        task.setTaskStatus(Byte.parseByte(taskDto.getTaskStatus()));
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
        taskDto.setTeamId(String.valueOf(task.getTeamId()));
        taskDto.setProId(String.valueOf(task.getProId()));
        taskDto.setTaskCreateTime(String.valueOf(task.getTaskCreateTime()));
        taskDto.setTaskStartTime(String.valueOf(task.getTaskStartTime()));
        taskDto.setTaskEndTime(String.valueOf(task.getTaskEndTime()));
        taskDto.setTaskContent(task.getTaskContent());
        taskDto.setUserId(String.valueOf(task.getUserId()));
        taskDto.setSubTaskId(String.valueOf(task.getSubTaskId()));
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
        myTaskDto.setTaskStartTime(String.valueOf(task.getTaskStartTime()));
        myTaskDto.setTaskEndTime(String.valueOf(task.getTaskEndTime()));
        myTaskDto.setTaskStatus(String.valueOf(task.getTaskStatus()));
        return myTaskDto;
    }
}
