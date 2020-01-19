package crw.bishe.team.dtoEntityMapping;

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
        if(taskDto.getId() == null || taskDto.getId() == ""){
            task.setId(null);
        }else{
            task.setId(Long.parseLong(taskDto.getId()));
        }
        task.setTaskId(Long.parseLong(taskDto.getTaskId()));
        task.setTeamId(Long.parseLong(taskDto.getTeamId()));
        task.setProId(Long.parseLong(taskDto.getProId()));
        task.setTaskCreateTime(Date.valueOf(taskDto.getTaskCreateTime()));
        task.setTaskStartTime(Date.valueOf(taskDto.getTaskStartTime()));
        task.setTaskEndTime(Date.valueOf(taskDto.getTaskEndTime()));
        task.setTaskContent(taskDto.getTaskContent());
        task.setTaskCharger(taskDto.getTaskCharger());
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
        taskDto.setId(String.valueOf(task.getId()));
        taskDto.setTaskId(String.valueOf(task.getTaskId()));
        taskDto.setTeamId(String.valueOf(task.getTeamId()));
        taskDto.setProId(String.valueOf(task.getProId()));
        taskDto.setTaskCreateTime(String.valueOf(task.getTaskCreateTime()));
        taskDto.setTaskStartTime(String.valueOf(task.getTaskStartTime()));
        taskDto.setTaskEndTime(String.valueOf(task.getTaskEndTime()));
        taskDto.setTaskContent(task.getTaskContent());
        taskDto.setTaskCharger(task.getTaskCharger());
        taskDto.setSubTaskId(String.valueOf(task.getSubTaskId()));
        taskDto.setTaskStatus(String.valueOf(task.getTaskStatus()));
        taskDto.setTaskMark(task.getTaskMark());
        return taskDto;
    }
}
