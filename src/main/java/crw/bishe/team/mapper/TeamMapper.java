package crw.bishe.team.mapper;

import crw.bishe.team.dto.MemberDto;
import crw.bishe.team.dto.MyTeamDto;
import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.dto.TeamProDto;
import crw.bishe.team.entity.Team;
import crw.bishe.team.vo.ConditionRequest;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface TeamMapper extends Mapper<Team> {

    /**
     * 通过管理员Id获取项目信息
     * @param adminId
     * @return
     */
    @Select("SELECT * FROM team WHERE team.`admin_id` = #{adminId}")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
                    many = @Many(select = "crw.bishe.team.mapper.ProjectMapper.getProjectByTeamId"))
    })
    List<TeamDto> getTeamByAdminId(Long adminId);

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
    @Select("SELECT * FROM team WHERE team_scope IN (SELECT university FROM user_info WHERE user_info.`user_id` = #{arg0}) AND team.`status` = 1;")
    List<Team> getTeamsByUniversity(Long user_id);

    /**
     * 查找校外所有团队
     * @return
     */
    @Select("SELECT * FROM team WHERE team_scope = '所有学校' AND team.`status` = 1;")
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
     * 查询所有团队以及团队对应的项目信息
     * @return
     * 记录： 在select语句后面加“；”号和没加分号的区别，加分号会限制limit ?的分页查询等功能
     */
    @Select("SELECT team.*,user_info.`university` FROM team,user_info\n" +
            "WHERE team.`leader_id`=user_info.`user_id`")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
                    many = @Many(select = "crw.bishe.team.mapper.ProjectMapper.getProjectByTeamId"))
    })
    List<TeamDto> getTeams();

    /**
     * 通过team_id获取团队信息以及团队的项目信息
     * @param teamId
     * @return
     */
    @Select("SELECT team.*,user_info.`university` FROM team,user_info\n" +
            "WHERE team.`leader_id`=user_info.`user_id` AND team.`team_id` = #{teamId};")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
                    many = @Many(select = "crw.bishe.team.mapper.ProjectMapper.getProjectByTeamId"))
    })
    TeamDto getTeamProByTeamId(Long teamId);

    /**
         * 通过用户ID获取所有的团队信息以及团队的项目信息
     * @param userId
     * @return
     */
    @Select("SELECT team.*,user_info.`university` FROM team,user_info\n" +
            "            WHERE team.`leader_id`=user_info.`user_id` AND team.`team_id` IN (SELECT team_id FROM user_team WHERE user_id = #{userId} ) ;")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
                    many = @Many(select = "crw.bishe.team.mapper.ProjectMapper.getProjectByTeamId"))
    })
    List<TeamDto> getTeamProByUserId(Long userId);

    /**
     * 通过用户ID获取我的团队以及项目信息
     * @param userId
     * @return
     */
    @Select("SELECT team.* FROM team WHERE team.`leader_id` = #{userId};")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
                    many = @Many(select = "crw.bishe.team.mapper.ProjectMapper.getProjectByTeamId"))
    })
    List<TeamDto> getMyTeamProByUserId(Long userId);


    /**
     * 通过用户ID获取参与的团队以及项目信息
     * @param userId
     * @return
     */
    @Select("SELECT team.* FROM team WHERE  team.`team_id` IN (SELECT team_id FROM user_team WHERE user_id = #{userId}  AND user_team.`is_leader`=0) ;")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
                    many = @Many(select = "crw.bishe.team.mapper.ProjectMapper.getProjectByTeamId"))
    })
    List<TeamDto> getJoinTeamProByUserId(Long userId);

    /**
     * 根据团队名模糊查询团队信息
     * @param teamName
     * @return
     */
    @Select("SELECT team.*,user_info.`university` FROM team,user_info\n" +
            "WHERE team.`leader_id`=user_info.`user_id` AND team.`team_name` LIKE  #{teamName} AND team.`status` = 1;")
    List<TeamDto> getTeamByTeamName(String teamName);

    /**
     * 根据学校范围查询团队信息
     * @param teamScope
     * @return
     */
    @Select("SELECT team.*,user_info.`university` FROM team,user_info\n" +
            "WHERE team.`leader_id`=user_info.`user_id` AND team.`team_scope` = #{teamScope} AND team.`status` = 1;")
    @Results({
            @Result(property = "teamId", column = "team_id"),
            @Result(property = "projects", column = "team_id",
                    many = @Many(select = "crw.bishe.team.mapper.ProjectMapper.getProjectByTeamId"))
    })
    List<TeamDto> getTeamByteamScope(String teamScope);

    /**
     * 通过团队类型查找团队信息
     * @param teamType
     * @return
     */
    @Select("SELECT team.*,user_info.`university` FROM team,user_info\n" +
            "            WHERE team.`leader_id`=user_info.`user_id` AND team.`team_type` = #{teamType} AND team.`status` = 1;")
    List<TeamDto> getTeamByTeamType(String teamType);

    /**
     * 完成组队
     * @param teamId
     * @return
     */
    @Select("UPDATE team SET team.`status` = 2 WHERE team.`team_id`=#{teamId};")
    Integer TeamStatusFinish(Long teamId);

    /**
     * 同意发起组队
     * @param teamId
     * @return
     */
    @Select("UPDATE team SET team.`status` = 1 WHERE team.`team_id`=#{teamId};")
    Integer agree(Long teamId);

    /**
     * 同意发起组队
     * @param teamId
     * @return
     */
    @Select("UPDATE team SET team.`status` = -1 WHERE team.`team_id`=#{teamId};")
    Integer disagree(Long teamId);

    /**
     * 继续组队
     * @param teamId
     * @return
     */
    @Select("UPDATE team SET team.`status` = 1 WHERE team.`team_id`=#{teamId};")
    Integer TeamStatusContinue(Long teamId);


    @Insert("INSERT INTO team VALUES (null, #{teamName}, #{adminId}, #{leaderId}, #{leaderName}, #{teamDescribe}, #{teamType}, #{teamScope}, #{teamNumber}, #{sumNumber}, #{teamDate}, #{status}, #{staff}, #{teamNature}, #{teamLabel}, #{seeNum})")
    @Options(useGeneratedKeys = true, keyProperty = "teamId", keyColumn = "team_id")
    int saveTeam( Team team);

}