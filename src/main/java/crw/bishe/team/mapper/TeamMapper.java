package crw.bishe.team.mapper;

import crw.bishe.team.dto.MemberDto;
import crw.bishe.team.dto.MyTeamDto;
import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.entity.Team;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface TeamMapper extends Mapper<Team> {

    @Select("SELECT team.`team_id`,team.`team_name`,user_team.`is_leader`,team.`team_describe` FROM team , user_info ,user_team WHERE team.`team_id` = user_team.`team_id` AND user_team.`user_id` = user_info.`user_id`AND user_info.`user_id` = #{id}")
    List<MyTeamDto> getMyTeamList(Long id);

    /**
     * 通过团队ID获取该团队的成员列表
     * @param teamId
     * @return
     */
    @Select("SELECT user_team.`ut_id`,user_team.`team_id`,user_info.`user_id`,user_info.`user_name` FROM user_team, user_info \n" +
            "WHERE user_team.`user_id`=user_info.`user_id` AND  user_team.`team_id`= #{arg0};")
    List<MemberDto> getMemberList(Long teamId);

    /**
     * 查找校内所有团队
     * @param user_id
     * @return
     */
    @Select("SELECT * FROM team WHERE team_scope IN (SELECT university FROM user_info WHERE user_info.`user_id` = #{arg0};")
    List<Team> getTeamsByUniversity(Long user_id);

    /**
     * 查找校外所有团队
     * @return
     */
    @Select("SELECT * FROM team WHERE team_scope = '所有学校';")
    List<Team> getTeamsByOtherUniversity();

    /**
     * 获取我的团队以及团队对应的项目
     * @param user_id
     * @return
     */
    @Select("SELECT DISTINCT team.`team_id`,  team.`team_name`,project.* FROM team,project,user_team WHERE user_team.`user_id` = #{arg0} AND user_team.`is_leader`= 1 AND user_team.`team_id`=team.`team_id` AND project.`team_id`=team.`team_id`;  ")
    List<String> getMyTeamAndProject(Long user_id);

    /**
     * 获取我参加团队以及团队对应的项目
     * @param user_id
     * @return
     */
    @Select("SELECT DISTINCT team.`team_id`,  team.`team_name`,project.* FROM team,project,user_team WHERE user_team.`user_id` = #{arg0} AND user_team.`is_leader`= 0 AND user_team.`team_id`=team.`team_id` AND project.`team_id`=team.`team_id`; ")
    List<String> getMyJoinTeamAndProject(Long user_id);


    /**
     * 通过team_id查找项目信息
     * @param teamId
     * @return
     */
        @Select("SELECT project.* FROM project WHERE project.`team_id`= #{teamId};")
    public List<ProjectDto> getProjectByTeamId(Long teamId);

    /**
     * 查询所有团队以及团队对应的项目信息
     * @return
     */
    @Select("SELECT team.*,user_info.`university` FROM team,user_info\n" +
            "WHERE team.`leader_id`=user_info.`user_id`;")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
            many = @Many(select = "crw.bishe.team.mapper.TeamMapper.getProjectByTeamId"))
    })
    List<TeamDto> getTeams();

}