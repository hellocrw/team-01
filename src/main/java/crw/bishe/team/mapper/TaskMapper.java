package crw.bishe.team.mapper;

import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.dto.TaskDto;
import crw.bishe.team.dto.TaskListDto;
import crw.bishe.team.entity.Task;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据proIds删除projects
     * @param proIds
     * @return
     */
    @Delete("<script>"
            + "DELETE FROM task WHERE pro_id IN "
            + "<foreach item='item' index='index' collection='proIds' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    Integer deleteByProIds(@Param("proIds") List<Long> proIds);

    /**
     * proIds --> tasks
     * @param proIds
     * @return
     */
    @Select("<script>"
            + "SELECT * FROM task WHERE pro_id IN "
            + "<foreach item='item' index='index' collection='proIds' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<TaskDto> selectByProIds(@Param("proIds") List<Long> proIds);

    @Insert("INSERT INTO task VALUE (NULL,#{proId},#{taskCreateTime},#{taskStartTime},#{taskEndTime},#{taskContent},#{userId},#{userName},#{taskStatus},#{taskMark} )")
    @Options(useGeneratedKeys = true, keyProperty = "taskId", keyColumn = "task_id")
    Integer create(Task task);

    @Update("UPDATE task SET pro_id = #{proId},task_create_time = #{taskCreateTime},task_start_time = #{taskStartTime},task_end_time = #{taskEndTime},task_content = #{taskContent},user_id = #{userId},user_name = #{userName},task_status = #{taskStatus},task_mark = #{taskMark} WHERE task_id = #{taskId} ")
    Integer update(Task task);

}