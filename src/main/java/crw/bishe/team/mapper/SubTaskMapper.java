package crw.bishe.team.mapper;

import crw.bishe.team.dto.SubTaskDto;
import crw.bishe.team.entity.SubTask;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SubTaskMapper extends Mapper<SubTask> {

    /**
     * 通过任务ID获取子任务信息
     * @param taskId
     * @return
     */
    @Select("SELECT * FROM sub_task WHERE sub_task.`task_id`=#{taskId};")
    List<SubTaskDto> getSubTaskByTaskId(Long taskId);
}