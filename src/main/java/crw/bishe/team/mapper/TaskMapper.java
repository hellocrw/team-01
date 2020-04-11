package crw.bishe.team.mapper;

import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.dto.TaskListDto;
import crw.bishe.team.entity.Task;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TaskMapper extends Mapper<Task> {

    /**
     * 根据用户ID查看用户的任务信息
     * @param userId
     * @return
     */
    @Select("SELECT task.* FROM task WHERE task.`user_id` = #{userId}")
    @Results({
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "subTaskDtos", column = "task_id",
                    many = @Many(select = "crw.bishe.team.mapper.SubTaskMapper.getSubTaskByTaskId"))
    })
    List<TaskDto> getTaskByUserId(Long userId);

    @Select(" SELECT DISTINCT task.`task_id`,task.`task_start_time`,task.`task_end_time`,task.`task_content`,user_info.`user_name` AS taskCharger,task.`sub_task_id`,task.`task_status` FROM task,user_info WHERE task.`pro_id`=#{arg0} AND task.`user_id` = user_info.`user_id`;")
    List<TaskListDto> getTaskList(Long proId);

    /**
     * 根据项目ID查找所有任务信息
     * @param proId
     * @return
     */
    @Select("SELECT task.* FROM task WHERE pro_id = #{proId};")
    @Results({
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "subTaskDtos", column = "task_id",
                    many = @Many(select = "crw.bishe.team.mapper.SubTaskMapper.getSubTaskByTaskId"))
    })
    List<TaskDto> geTaskByProId(Long proId);

    /**
     * 根据任务id更新任务状态信息
     * @param taskId
     */
    @Select("UPDATE task SET task.`task_status`=task.`task_status`+1 WHERE task.`task_id` = #{taskId};")
    Integer updateTaskByTaskId(Long taskId);

}