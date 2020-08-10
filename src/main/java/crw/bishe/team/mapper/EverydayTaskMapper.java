package crw.bishe.team.mapper;

import crw.bishe.team.entity.EverydayTask;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EverydayTaskMapper extends Mapper<EverydayTask> {

    /**
     * 获取用户每天任务信息
     * @param userId
     * @return
     */
    @Select("SELECT * FROM everyday_task WHERE user_id=#{userId}")
    List<EverydayTask> qureyEverydayTask(Long userId);

    @Update("UPDATE everyday_task SET clock_time = NOW() WHERE user_id=#{param1} AND everyday_task_id = #{param2};")
    @Options(useGeneratedKeys = true, keyProperty = "param2.id", keyColumn = "everyday_task_id")
    Integer updateClockTime(Long userId, Long everyTaskId);

}