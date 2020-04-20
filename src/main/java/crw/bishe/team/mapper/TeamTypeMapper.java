package crw.bishe.team.mapper;

import crw.bishe.team.dto.TeamTypeDto;
import crw.bishe.team.entity.TeamType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TeamTypeMapper extends Mapper<TeamType> {
    /**
     * 查询团队类型
     * @return
     */
    @Select("select * from team_type")
    List<TeamTypeDto> selectTeamType();

    /**
     * 通过key查询value
     * @param key
     * @return
     */
    @Select("SELECT team_type.`value` FROM team_type WHERE team_type.`key` = #{key};")
    String getValueByKey(Long key);

    /**
     * 获取团队各类型的数量
     * @param userId
     * @return
     */
    @Select("SELECT team.`team_type` AS x,COUNT(team.`team_type`) AS y FROM team,user_info WHERE team.`leader_id`=user_info.`user_id` AND team.`team_id` IN (SELECT team_id FROM user_team WHERE user_id = #{userId} ) \n" +
            "GROUP BY team.`team_type`;")
    List<Map<String, Object>> getTeamTypeNumber(Long userId);

    /**
     * 获取项目类型数据分析
     * @param userId
     * @return
     */
    @Select("SELECT project.`pro_type` AS x, COUNT(project.`pro_type`) AS y FROM project\n" +
            "WHERE project.`team_id` IN (SELECT team.`team_id` FROM team, user_team WHERE team.`team_id` = user_team.`team_id` AND user_team.`user_id` = #{userId})\n" +
            "GROUP BY project.`pro_type`;")
    List<Map<String, Object>> getProTypeNumber(Long userId);

    /**
     * 获取任务类型数据分析
     * @param userId
     * @return
     */
    @Select("SELECT task.`task_status` AS x , COUNT(task.`task_status`) AS y FROM task WHERE task.`pro_id` \n" +
            "IN \n" +
            "(SELECT project.`pro_id` FROM project\n" +
            "WHERE project.`team_id` IN (SELECT team.`team_id` FROM team, user_team WHERE team.`team_id` = user_team.`team_id` AND user_team.`user_id` = 1))\n" +
            "GROUP BY task.`task_status`;")
    List<Map<String, Object>> getTaskTypeNumber(Long userId);

    /**
     * 管理员获取团队分析数据
     * @return
     */
    @Select("SELECT team.`team_type` AS x, COUNT(team.`team_type`) AS y FROM team \n" +
            "GROUP BY team.`team_type`;")
    List<Map<String,Object>> getTeamAnalysis();

    /**
     * 管理员获取用户分析数据
     * @return
     */
    @Select("SELECT user_info.`college` AS x, COUNT(user_info.`college`) AS y FROM user_info \n" +
            "GROUP BY user_info.`college`;")
    List<Map<String, Object>> getUserAnalysis();
}