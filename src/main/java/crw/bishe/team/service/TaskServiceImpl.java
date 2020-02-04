package crw.bishe.team.service;

import crw.bishe.team.dto.MyTaskDto;
import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.dto.TaskListDto;
import crw.bishe.team.dtoEntityMapping.TaskMapping;
import crw.bishe.team.entity.Task;
import crw.bishe.team.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/19
 * @Time 23:48
 **/
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskMapping taskMapping;

    @Autowired
    public TaskServiceImpl(TaskMapper taskMapper,TaskMapping taskMapping){
        this.taskMapper = taskMapper;
        this.taskMapping = taskMapping;
    }
    @Override
    public int create(TaskDto taskDto) {
        return taskMapper.insert(taskMapping.toEntity(taskDto));
    }

    @Override
    public int delete(String id) {
        Long key = Long.parseLong(id);
        return taskMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int update(TaskDto taskDto, String id) {
        Long key = Long.parseLong(id);
        if(taskMapper.selectByPrimaryKey(key) != null){
            taskMapper.updateByPrimaryKey(taskMapping.toEntity(taskDto));
        }
        return 0;
    }

    @Override
    public List<TaskDto> findAll() {
        List<Task> tasks = taskMapper.selectAll();
        List<TaskDto> taskDtos = new ArrayList<>();
        tasks.forEach(task -> taskDtos.add(taskMapping.toDto(task)));
        return taskDtos;
    }

    @Override
    public List<MyTaskDto> getMyTaskList(String userId) {
        Long key = Long.parseLong(userId);
        List<Task> tasks = taskMapper.getMyTaskList(key);
        System.out.println(tasks.get(1).getTaskStartTime());
        List<MyTaskDto> myTaskDtos = new ArrayList<>();
        tasks.forEach(task -> myTaskDtos.add(taskMapping.toMyTaskDto(task)));
        return myTaskDtos;
    }

    @Override
    public List<TaskListDto> getTaskList(String proId) {
        Long key = Long.parseLong(proId);
        return taskMapper.getTaskList(key);
    }
}
