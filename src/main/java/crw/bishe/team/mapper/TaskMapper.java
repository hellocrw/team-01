package crw.bishe.team.mapper;

import crw.bishe.team.entity.Task;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TaskMapper extends Mapper<Task> {

    /**
     * 根据用户ID查看用户的任务信息
     * @param user_id
     * @return
     */
    @Select("SELECT task.`task_id`,task.`task_start_time`,task.`task_end_time`,task.`task_content`,task.`task_status` FROM task WHERE task.`user_id` = #{arg0}")
    List<Task> getMyTaskList(Long user_id);
}