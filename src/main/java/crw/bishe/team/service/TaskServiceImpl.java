package crw.bishe.team.service;

import crw.bishe.team.dto.MyTaskDto;
import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.dto.TaskListDto;
import crw.bishe.team.dtoEntityMapping.TaskMapping;
import crw.bishe.team.entity.Task;
import crw.bishe.team.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private final SubTaskService subTaskService;

    @Autowired
    public TaskServiceImpl(TaskMapper taskMapper,TaskMapping taskMapping,SubTaskService subTaskService){
        this.taskMapper = taskMapper;
        this.taskMapping = taskMapping;
        this.subTaskService = subTaskService;
    }
    @Override
    public TaskDto create(TaskDto taskDto) {
        Task task = taskMapping.toEntity(taskDto);
        Integer res = taskMapper.create(task);
        return taskMapping.toDto(task);
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
    public List<TaskDto> getTaskByUserId(String userId) {
        Long key = Long.parseLong(userId);
        List<TaskDto> taskDtos = taskMapper.getTaskByUserId(key);
//        System.out.println(tasks.get(1).getTaskStartTime());
//        List<MyTaskDto> myTaskDtos = new ArrayList<>();
//        tasks.forEach(task -> myTaskDtos.add(taskMapping.toMyTaskDto(task)));
        return taskDtos;
    }

    @Override
    public List<TaskListDto> getTaskList(String proId) {
        Long key = Long.parseLong(proId);
        return taskMapper.getTaskList(key);
    }

    @Override
    public List<TaskDto> geTaskByProId(String proId) {
        Long key = Long.parseLong(proId);
        return taskMapper.geTaskByProId(key);
    }

    @Override
    public Integer updateTaskByTaskId(String taskId) {
        Long key = Long.parseLong(taskId);
        return taskMapper.updateTaskByTaskId(key);
    }

    @Override
    public Integer deleteByProIds(List<String> proIds) {
        // delect subTasks by taskIds
        List<Long> proIds_list = new ArrayList<>();
        proIds.forEach(proId ->{
            proIds_list.add(Long.parseLong(proId));
        });
        // 1. req: proIds --> taskIds
        List<String> taskIds = new ArrayList<>();
        taskMapper.selectByProIds(proIds_list).forEach(taskDto -> {
            taskIds.add(taskDto.getTaskId());
        });
        // 2. delete subTasks by taskIds
        if ( null !=taskIds && taskIds.size() != 0){
            subTaskService.deleteByTaskIds(taskIds);
        }
        // delete tasks
        return taskMapper.deleteByProIds(proIds_list);
    }
}
