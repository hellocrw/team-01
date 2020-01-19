package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.entity.Task;

/**
 * @description Description
 * @Author crw
 * @create 2020/1/19
 * @Time 23:00
 **/
public interface TaskMapping {

    /**
     * 将task的dto转为entity
     * @param taskDto
     * @return entity
     */
    Task toEntity(TaskDto taskDto);

    /**
     * 将task的entity转为dto
     * @param task
     * @return dto
     */
    TaskDto toDto(Task task);
}
