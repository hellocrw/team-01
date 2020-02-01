package crw.bishe.team.service;

import crw.bishe.team.dto.TaskDto;

import java.util.List;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/19
 * @Time 23:46
 **/
public interface TaskService {
    /**
     * 增加任务信息
     * @param taskDto
     * @return
     */
    int create(TaskDto taskDto);

    /**
     * 根据ID删除任务信息
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改任务信息
     * @param taskDto
     * @return
     */
    int update(TaskDto taskDto, String id);


    /**
     * 查找所有任务信息
     * @return
     */
    List<TaskDto> findAll();
}