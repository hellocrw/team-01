package crw.bishe.team.service;

import crw.bishe.team.dto.MemberDto;
import crw.bishe.team.dto.MyTeamDto;
import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.dto.TeamProDto;
import crw.bishe.team.entity.Team;
import crw.bishe.team.vo.PageRequest;
import crw.bishe.team.vo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 15:00
 */
public interface TeamService {
    /**
     * 增加团队信息
     * @param teamDto
     * @return
     */
    int create(TeamDto teamDto);

    /**
     * 根据ID删除团队信息
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改团队信息
     * @param teamDto
     * @return
     */
    int update(TeamDto teamDto, String id);


    /**
     * 查找所有团队信息
     * @return
     */
    List<TeamDto> findAll();

    /**
     *
     * @return
     */
    List<MyTeamDto> getMyTeamList(String id);

    /**
     * 通过团队ID获取团队的成员
     * @param teamId
     * @return
     */
    List<MemberDto> getMemberList(String teamId);

    /**
     * 获取所有团队以及团队的项目信息： one-to-many
     * @return
     */
    List<TeamDto> getTeams();

    /**
     * 通过teamId获取团队以及项目信息
     * @param teamId
     * @return
     */
    TeamDto getTeamProByTeamId(String teamId);

    /**
     * 通过用户ID获取所有团队以及对应的项目信息
     * @param userId
     * @return
     */
    List<TeamDto> getTeamProByUserId(String userId);

    /**
     * 获取我的团队
     * @param userId
     * @return
     */
    List<TeamDto> getMyTeamProByUserId(String userId);

    /**
     * 获取我参与的团队
     * @param userId
     * @return
     */
    List<TeamDto> getJoinTeamProByUserId(String userId);

    /**
     * 模糊查询团队信息
     * @param teamName
     * @return
     */
    List<TeamDto> getTeamByTeamName(String teamName);

    void saveTeam(TeamDto teamDto);

    List<TeamDto> getTeamByteamScope(String teamScope);

    /**
     * 通过团队类型获取团队信息
     * @param teamType
     * @return
     */
    List<TeamDto> getTeamByTeamType(String teamType);

    /**
     * 分页查询团队信息
     * @param pageRequest
     * @return
     */
    PageResult pageTeams(PageRequest pageRequest);

}
