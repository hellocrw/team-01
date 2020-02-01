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
}