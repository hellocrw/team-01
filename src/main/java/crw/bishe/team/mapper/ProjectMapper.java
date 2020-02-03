package crw.bishe.team.mapper;

import crw.bishe.team.entity.Project;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ProjectMapper extends Mapper<Project> {

    /**
     * 通过团队ID获取该团队下的项目列表
     * @param team_id 团队ID
     * @return
     */
    @Select("SELECT DISTINCT user_info.`user_name` as leader_name, project.`team_id`, project.`team_name`,project.`pro_id`,project.`pro_name`,project.`pro_describe`,project.`pro_date`,project.`pro_start_time`,project.`pro_end_time`,project.`pro_status`,project.`pro_type`,project.`pro_current_num`,project.`pro_limied_num`,project.`see_num`,project.`staff` \n" +
            "FROM project,user_info,team\n" +
            "WHERE project.`team_id`= #{team_id} AND team.`leader_id`=user_info.`user_id`; ")
    List<Map> getMyProList(int team_id);


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
     * 更新当前项目的查看人数
     * @param seeNum
     */
    @Select("UPDATE project SET see_num= #{arg0} WHERE pro_id=#{arg1};")
    void updateSeeNum(Integer seeNum, Integer pro_id);

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
}