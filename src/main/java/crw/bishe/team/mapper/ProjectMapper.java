package crw.bishe.team.mapper;

import crw.bishe.team.dto.MyProListDto;
import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.dto.TeamProDto;
import crw.bishe.team.entity.Project;
import crw.bishe.team.vo.ConditionRequest;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ProjectMapper extends Mapper<Project> {

    /**
     * 根据查询条件查询项目信息
     * @param conditionRequest
     * @return
     */
    @Select("SELECT * FROM (SELECT project.* ,team.`team_number` AS proNum,team.`team_type` AS proNature, team.`team_describe`,team.`team_scope` AS university FROM project,team WHERE project.`team_id` = team.`team_id`) AS selectPro\n" +
            "WHERE \n" +
            "(CASE WHEN #{university} IS NOT NULL and #{university} != '' THEN selectPro.university=#{university} ELSE (1=1) END)\n" +
            "AND \n" +
            "(CASE WHEN #{proType} IS NOT NULL and #{proType} != ''THEN selectPro.pro_type=#{proType} ELSE (1=1) END)\n" +
            "AND\n" +
            "(CASE WHEN #{key} IS NOT NULL and #{key} != '' THEN selectPro.pro_name LIKE #{key} ELSE (1=1) END)\n" +
            "AND\n" +
            "(CASE WHEN #{proId} IS NOT NULL and #{proId} != '' THEN selectPro.pro_id=#{proId} ELSE (1=1) END);")
    List<TeamProDto> getProBySelectCondition(ConditionRequest conditionRequest);

    @Select("SELECT project.* ,team.`team_number` AS proNum,team.`team_type` AS proNature, team.`team_describe`,team_scope AS university FROM project,team WHERE project.`team_id` = team.`team_id`;")
    List<TeamProDto> getTeamProInfo();

    /**
     * 通过团队ID获取该团队下的项目列表
     * @param team_id 团队ID
     * @return
     */
    @Select("SELECT DISTINCT user_info.`user_name` as leader_name, project.`team_id`, team.`team_name`,project.`pro_id`,project.`pro_name`,project.`pro_describe`,project.`pro_date`,project.`pro_start_time`,project.`pro_end_time`,project.`pro_status`,project.`pro_type`,project.`pro_current_num`,project.`pro_limied_num`,project.`see_num`,project.`staff` \n" +
            "FROM project,user_info,team\n" +
            "WHERE project.`team_id`= #{team_id} AND team.`leader_id`=user_info.`user_id`; ")
    List<MyProListDto> getMyProList(int team_id);


    /**
     * 通过team_id查找项目信息
     * @param teamId
     * @return
     */
    @Select("SELECT project.* FROM project WHERE project.`team_id`= #{teamId};")
    List<ProjectDto> getProjectByTeamId(Long teamId);

    /**
     * 根据项目名称 项目类型，学校搜索所有符合条件的项目
     * @param pro_name 项目名称
     * @param pro_type 项目类型
     * @param university 学校
     * @return
     */
    List<Map> getAllProBySelect(String pro_name,String pro_type, String university);

    /**
     * 查看当前项目的查看人数
     * @return
     */
    @Select("SELECT see_num FROM project WHERE pro_id = #{arg0};")
    Integer getSeeNum(Integer pro_id);


    /**
     * Web的查看人数
     * @param seeNum
     * @param pro_id
     */
    @Select("UPDATE project SET see_num= #{arg0} WHERE pro_id=#{arg1};")
    void updateWebNum(Integer seeNum, Integer pro_id);

    /**
     * 项目查看人数+1
     * @param pro_id
     */
    @Select("UPDATE project SET see_num=see_num+1 WHERE pro_id=#{arg0};")
    void updateSeeNum(Integer pro_id);

    /**
     * 查找校内所有项目
     * @param user_id
     * @return
     */
    @Select("SELECT * FROM project WHERE project.`team_id` IN (SELECT team.`team_id` FROM team WHERE team_scope IN (SELECT university FROM user_info WHERE user_info.`user_id`=#{arg0}));")
    List<Project> getProjectByUniversity(Long user_id);

    /**
     * 按类型查找校内所有项目
     * @param user_id
     * @param pro_type
     * @return
     */
    @Select("SELECT * FROM project WHERE project.`team_id` IN (SELECT team.`team_id` FROM team WHERE team_scope IN (SELECT university FROM user_info WHERE user_info.`user_id`=#{arg0})) AND pro_type= #{arg1};")
    List<Project> getProjectByUniversityType(Long user_id, String pro_type);

    /**
     * 查看校外所有项目
     * @return
     */
    @Select("SELECT * FROM project WHERE project.`team_id` IN (SELECT team.`team_id` FROM team WHERE team_scope='所有学校');")
    List<Project> getProjectByOtherUniversity();

    /**
     * 按类型查找校外所有项目
     * @return
     */
    @Select("SELECT * FROM project WHERE project.`team_id` IN (SELECT team.`team_id` FROM team WHERE team_scope='所有学校') AND pro_type=#{arg0};")
    List<Project> getProjectByOtherUniversityType(String pro_type);

    @Select("SELECT * FROM project where pro_id = #{proId}")
    ProjectDto getProjectByProId(Long proId);
    /**
     * 通过项目ID获取项目信息以及项目的任务信息
     * @param proId 项目ID
     * @return
     */
    @Select("SELECT project.* FROM project WHERE project.`pro_id` = #{proId};")
    @Results({
            @Result(property = "proId", column = "pro_id"),
            @Result(property = "taskDtos", column = "pro_id",
                    many = @Many(select = "crw.bishe.team.mapper.TaskMapper.geTaskByProId"))
    })
    ProjectDto getProjectTaskByProId(Long proId);

    /**
     * 根据项目名模糊查询项目信息
     * @param proName
     * @return
     */
    @Select("SELECT * FROM project WHERE project.`pro_name`LIKE #{proName};")
    List<ProjectDto> getProjectByProName(String proName);
}