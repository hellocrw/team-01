package crw.bishe.team.mapper;

import crw.bishe.team.dto.SubTaskDto;
import crw.bishe.team.entity.SubTask;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SubTaskMapper extends Mapper<SubTask> {

    /**
     * 通过任务ID获取子任务信息
     * @param taskId
     * @return
     */
    @Select("SELECT * FROM sub_task WHERE sub_task.`task_id`=#{taskId};")
    List<SubTaskDto> getSubTaskByTaskId(Long taskId);

    /**
     * 根据tasksId删除sub_task -->  级联删除
     * @param taskIds
     * @return
     */
    @Delete("<script>"
            + "DELETE FROM sub_task WHERE task_id IN "
            + "<foreach item='item' index='index' collection='taskIds'      open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    Integer deleteByTaskIds(@Param("taskIds") List<Long> taskIds);


    /**
     * 根据tasksId查询 --> 级联查询
     * @param taskIds
     * @return
     */
    @Select("<script>"
            + "SELECT * FROM sub_task WHERE task_id IN "
            + "<foreach item='item' index='index' collection='taskIds'      open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<SubTaskDto> selectByTaskIds(@Param("taskIds") List<Long> taskIds);
}