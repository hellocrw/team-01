package crw.bishe.team.mapper;

import crw.bishe.team.dto.TaskListDto;
import crw.bishe.team.entity.Task;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TaskMapper extends Mapper<Task> {

    /**
     * 根据用户ID查看用户的任务信息
     * @param userId
     * @return
     */
    @Select("SELECT task.`task_id`,task.`task_start_time`,task.`task_end_time`,task.`task_content`,task.`task_status` FROM task WHERE task.`user_id` = #{arg0}")
    List<Task> getMyTaskList(Long userId);

    @Select(" SELECT DISTINCT task.`task_id`,task.`task_start_time`,task.`task_end_time`,task.`task_content`,user_info.`user_name` AS taskCharger,task.`sub_task_id`,task.`task_status` FROM task,user_info WHERE task.`pro_id`=#{arg0} AND task.`user_id` = user_info.`user_id`;")
    List<TaskListDto> getTaskList(Long proId);
}