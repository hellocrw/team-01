package crw.bishe.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import crw.bishe.team.dto.*;
import crw.bishe.team.dtoEntityMapping.TeamMapping;
import crw.bishe.team.dtoEntityMapping.TeamMappingImpl;
import crw.bishe.team.entity.Team;
import crw.bishe.team.entity.UserTeam;
import crw.bishe.team.mapper.AdminMapper;
import crw.bishe.team.mapper.ProjectMapper;
import crw.bishe.team.mapper.TeamMapper;
import crw.bishe.team.mapper.UserTeamMapper;
import crw.bishe.team.utils.PageUtils;
import crw.bishe.team.vo.PageRequest;
import crw.bishe.team.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    private final AdminMapper adminMapper;
    private final ProjectService projectService;
    private final ApplyService applyService;
    private final UserTeamService userTeamService;
    private final UserTeamMapper userTeamMapper;

    @Autowired
    public TeamServiceImpl(TeamMapper teamMapper,
                           TeamMapping teamMapping,
                           AdminMapper adminMapper,
                           ProjectService projectService,
                           ApplyService applyService,
                           UserTeamService userTeamService,
                           UserTeamMapper userTeamMapper){
        this.teamMapper = teamMapper;
        this.teamMapping = teamMapping;
        this.adminMapper = adminMapper;
        this.projectService = projectService;
        this.applyService = applyService;
        this.userTeamService = userTeamService;
        this.userTeamMapper = userTeamMapper;
    }

    @Override
    public List<TeamDto> getTeamByAdminId(String adminId) {
        Long key = Long.parseLong(adminId);
        return teamMapper.getTeamByAdminId(key);
    }

    @Override
    public int create(TeamDto teamDto) {
        if(teamDto == null){
            return 0;
        }
        return teamMapper.insert(teamMapping.toEntity(teamDto));
    }

    /**
     * 级联删除：先删除外键，再删除主键
     * 1、删除申请表 --》 2、删除用户团队关联表 --》 3、删除项目  --》 4、删除团队
     * @param teamId
     * @return
     */
    @Override
    public int delete(String teamId) {
        // 1、delete applys
        applyService.deleteByTeamId(teamId);
        // 2.、delete userTeams
        userTeamService.deleteByTeamId(teamId);
        // 3、delete projects by teamId
        Long key = Long.parseLong(teamId);
        projectService.delectByTeamId(teamId);
        // 4、delete team
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
        List<TeamDto> teamDtos = new ArrayList<>();
        teamMapper.getTeams().forEach(teamDto -> {
            if (teamDto.getStatus().equals("1")){
                teamDtos.add(teamDto);
            }
        });
        return teamDtos;
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
    public int saveTeam(TeamDto teamDto) {
        // 判断adminId是否存在，不存在则不保存
        if(teamDto.getAdminId().equals("") || teamDto.getAdminId() == null){
            return 0;
        }
        Long adminId = Long.parseLong(teamDto.getAdminId());
        if (adminMapper.findAdminId(adminId) == null){
            return -1;
        }
        // 转换成实体类并保存团队数据并保存
        Team team = teamMapping.toEntity(teamDto);
        int res = teamMapper.saveTeam(team);
        System.out.println("返回结果： " + res);    // 返回的是执行函数
        System.out.println(team.getTeamId());   //  将插入的team返回,getTeamId取数据
        UserTeam userTeam = UserTeam.builder()
                .utId(null)
                .userId(team.getLeaderId())
                .userName(team.getLeaderName())
                .teamId(team.getTeamId())
                .teamName(team.getTeamName())
                .isLeader(Byte.parseByte("1"))
                .build();
        // 保存用户-团队关联表数据
        userTeamMapper.insert(userTeam);
        // 判断是否是系统管理员ID: AdminId = 0
        if (teamDto.getAdminId().equals("0")){   // 如果是，直接组队成功
            this.agree(String.valueOf(team.getTeamId()));
        }
        return res;
    }

    @Override
    public List<TeamDto> getTeamByteamScope(String teamScope) {
        return teamMapper.getTeamByteamScope(teamScope);
    }

    @Override
    public List<TeamDto> getTeamByTeamType(String teamType) {
        Long key = Long.parseLong(teamType);
        return teamMapper.getTeamByTeamType(key);
    }

    @Override
    public PageResult pageTeams(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
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
        List<Team> teams = teamMapper.selectAll();
//        List<TeamDto> teamDtos = this.findAll();
        return new PageInfo<>(teams);
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

    @Override
    public Integer agree(String teamId) {
        Long key = Long.parseLong(teamId);
        return teamMapper.agree(key);
    }

    @Override
    public Integer disagree(String teamId) {
        Long key = Long.parseLong(teamId);
        return teamMapper.disagree(key);
    }

    @Override
    public Boolean isLeader(String teamId, String userId) {
        TeamDto teamDto = this.getTeamProByTeamId(teamId);
        if (teamDto.getLeaderId().equals(userId)){
            return true;
        }
        return false;
    }


}
