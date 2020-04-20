package crw.bishe.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import crw.bishe.team.dto.MemberDto;
import crw.bishe.team.dto.MyTeamDto;
import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.dto.TeamProDto;
import crw.bishe.team.dtoEntityMapping.TeamMapping;
import crw.bishe.team.dtoEntityMapping.TeamMappingImpl;
import crw.bishe.team.entity.Team;
import crw.bishe.team.mapper.TeamMapper;
import crw.bishe.team.utils.PageUtils;
import crw.bishe.team.vo.PageRequest;
import crw.bishe.team.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 15:03
 */
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamMapping teamMapping;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamServiceImpl(TeamMapper teamMapper, TeamMapping teamMapping){
        this.teamMapper = teamMapper;
        this.teamMapping = teamMapping;
    }
    @Override
    public int create(TeamDto teamDto) {
        if(teamDto == null){
            return 0;
        }
        return teamMapper.insert(teamMapping.toEntity(teamDto));
    }

    @Override
    public int delete(String id) {
        Long key = Long.parseLong(id);
        return teamMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int update(TeamDto teamDto, String id) {
        if(teamDto == null){
            return 0;
        }
        Long key = Long.parseLong(id);
        if(teamMapper.selectByPrimaryKey(key) == null){
            return 0;
        }
        return teamMapper.updateByPrimaryKey(teamMapping.toEntity(teamDto));
    }

    @Override
    public List<TeamDto> findAll() {
        List<Team> teams = teamMapper.selectAll();
        List<TeamDto> teamDtos = new ArrayList<>();
        teams.forEach(team -> teamDtos.add(teamMapping.toDto(team)));
        return teamDtos;
    }

    @Override
    public List<MyTeamDto> getMyTeamList(String id) {
        Long key = Long.parseLong(id);
        List<MyTeamDto> teamList = teamMapper.getMyTeamList(key);
        return teamList;
    }
    @Override
    public List<MemberDto> getMemberList(String teamId) {
        Long key = Long.parseLong(teamId);
        return teamMapper.getMemberList(key);
    }

    @Override
    public List<TeamDto> getTeams() {
        return teamMapper.getTeams();
    }

    @Override
    public TeamDto getTeamProByTeamId(String teamId) {
        Long key = Long.parseLong(teamId);
        return teamMapper.getTeamProByTeamId(key);
    }

    @Override
    public List<TeamDto> getTeamProByUserId(String userId) {
        Long key = Long.parseLong(userId);
        return teamMapper.getTeamProByUserId(key);
    }

    @Override
    public List<TeamDto> getMyTeamProByUserId(String userId) {
        Long key = Long.parseLong(userId);
        return teamMapper.getMyTeamProByUserId(key);
    }

    @Override
    public List<TeamDto> getJoinTeamProByUserId(String userId) {
        Long key = Long.parseLong(userId);
        return teamMapper.getJoinTeamProByUserId(key);
    }

    @Override
    public List<TeamDto> getTeamByTeamName(String teamName) {
        String key = "%" + teamName + "%";
        return teamMapper.getTeamByTeamName(key);
    }

    @Override
    public void saveTeam(TeamDto teamDto) {
        Team team = teamMapping.toEntity(teamDto);
        teamMapper.insert(team);
    }

    @Override
    public List<TeamDto> getTeamByteamScope(String teamScope) {
        return teamMapper.getTeamByteamScope(teamScope);
    }

    @Override
    public List<TeamDto> getTeamByTeamType(String teamType) {
        return teamMapper.getTeamByTeamType(teamType);
    }

    @Override
    public PageResult pageTeams(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    @Override
    public Integer TeamStatusFinish(String teamId) {
        Long key = Long.parseLong(teamId);
        return teamMapper.TeamStatusFinish(key);
    }

    @Override
    public Integer TeamStatusContinue(String teamId) {
        Long key = Long.parseLong(teamId);
        return teamMapper.TeamStatusContinue(key);
    }

    /**
     * 分页查询团队信息
     * @param pageRequest
     * @return
     */
    public PageInfo getPageInfo(PageRequest pageRequest) {
        int pageNum = Integer.parseInt(pageRequest.getPageNum());
        int pageSize = Integer.parseInt(pageRequest.getPageSize());
        PageHelper.startPage(pageNum, pageSize);
        List<TeamDto> teamDtos = this.getTeams();
        return new PageInfo<>(teamDtos);
    }

}
