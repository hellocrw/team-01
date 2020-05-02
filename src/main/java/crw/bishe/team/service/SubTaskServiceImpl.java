package crw.bishe.team.service;

import crw.bishe.team.dto.SubTaskDto;
import crw.bishe.team.mapper.SubTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SubTaskServiceImpl implements SubTaskService {
    @Autowired
    private SubTaskMapper subTaskMapper;
    @Override
    public Integer deleteByTaskIds(List<String> taskIds) {
        // delete subTasks by taskIds
        List<Long> taskIds_list = new ArrayList<>();
        taskIds.forEach(taskid -> {
            taskIds_list.add(Long.parseLong(taskid));
        });
        return subTaskMapper.deleteByTaskIds(taskIds_list);
    }

    @Override
    public List<SubTaskDto> selectByTaskIds(List<String> taskIds) {
        List<Long> list = new ArrayList<>();
        taskIds.forEach(taskId -> {
            list.add(Long.parseLong(taskId));
        });
        return subTaskMapper.selectByTaskIds(list);
    }
}
