package crw.bishe.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import crw.bishe.team.dto.MyProListDto;
import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.dto.TeamProDto;
import crw.bishe.team.dtoEntityMapping.ProjectMapping;
import crw.bishe.team.entity.Project;
import crw.bishe.team.mapper.ProjectMapper;
import crw.bishe.team.utils.PageUtils;
import crw.bishe.team.vo.ConditionRequest;
import crw.bishe.team.vo.PageRequest;
import crw.bishe.team.vo.PageResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 17:14
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;
    private final ProjectMapping projectMapping;
    private final TaskService taskService;
    private final FilesService filesService;
    private final NoticeService noticeService;
    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper,
                              ProjectMapping projectMapping,
                              TaskService taskService,
                              FilesService filesService,
                              NoticeService noticeService){
        this.projectMapper = projectMapper;
        this.projectMapping = projectMapping;
        this.taskService = taskService;
        this.filesService = filesService;
        this.noticeService = noticeService;
    }
    @Override
    @CacheEvict(value = {"team", "myTeam", "joinTeam"}, allEntries = true)
    public ProjectDto create(ProjectDto projectDto) {
        if(projectDto == null){
            return null;
        }
        Project project = projectMapping.toEntity(projectDto);
        int res = projectMapper.saveProject(project);
        return projectMapping.toDto(project);
    }

    /**
     * 根据项目ID删除项目信息： 级联删除
     * @param proId
     * @return
     */
    @Override
    @CacheEvict(value = {"team", "myTeam", "joinTeam"}, allEntries = true)
    public Integer delete(String proId) {
        if(proId == null){
            return null;
        }
        Long key = Long.parseLong(proId);
        List<String> ids = new ArrayList<>();
        ids.add(proId);
        // delete task
        taskService.deleteByProIds(ids);
        // delete notice
        noticeService.deleteByProIds(ids);
        // delete files
        filesService.deleteByProIds(ids);
        // delete project
        return projectMapper.deleteByPrimaryKey(key);
    }

    /**
     * 删除项目级联删除：2删除任务--》 3删除文件 --》 4删除公告
     * @param teamId
     * @return
     */
    @Override
    @CacheEvict(value = {"team", "myTeam", "joinTeam"}, allEntries = true)
    public Integer delectByTeamId(String teamId) {
        // delete tasks by proIds
        Long key = Long.parseLong(teamId);
        // 1、req: teamId --> res: proIds
        List<String> proIds = new ArrayList<>();
        projectMapper.getProjectByTeamId(key).forEach(projectDto -> {
            proIds.add(projectDto.getProId());
        });
        if ( null != proIds && proIds.size() != 0){     //如果proIds 不存在，则不用删任务tasks了
            // 2、delete tasks by proIds
            taskService.deleteByProIds(proIds);
            // 3、delete files by proIds
            filesService.deleteByProIds(proIds);
            // 4、delete notices by proIds
            noticeService.deleteByProIds(proIds);
        }
        // delete projects
        return projectMapper.deleteByTeamId(key);
    }

    @Override
    public int update(ProjectDto projectDto, String id) {
        if(projectDto == null || id == null){
            return 0;
        }
        Long key = Long.parseLong(id);
        if(projectMapper.selectByPrimaryKey(key) == null){
            return 0;
        }
        return projectMapper.updateByPrimaryKey(projectMapping.toEntity(projectDto));
    }

    @Override
    public List<ProjectDto> findAll() {
        List<Project> projects = projectMapper.selectAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(project -> projectDtos.add(projectMapping.toDto(project)));
        return projectDtos;
    }

    @Override
    public List<MyProListDto> getMyProList(String team_id) {
        int key = Integer.parseInt(team_id);
        return projectMapper.getMyProList(key);
    }

    @Override
    public PageResult proPages(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    @Override
    public List<TeamProDto> getTeamProList() {
        return projectMapper.getTeamProInfo();
    }

    @Override
    public List<TeamProDto> getProBySelectCondition(ConditionRequest conditionRequest) {
        if (conditionRequest.getKey() != null || conditionRequest.getKey() != ""){
            conditionRequest.setKey("%"+conditionRequest.getKey()+"%");
        }
        return projectMapper.getProBySelectCondition(conditionRequest);
    }

    @Override
    public List<ProjectDto> getProjectByTeamId(String teamId) {
        Long key = Long.parseLong(teamId);
        return projectMapper.getProjectByTeamId(key);
    }

    @Override
    public ProjectDto getProjectByProId(String proId) {
        Long key = Long.parseLong(proId);
        return projectMapper.getProjectByProId(key);
    }

    @Override
    public ProjectDto getProjectTaskByProId(String proId) {
        Long key = Long.parseLong(proId);
        return projectMapper.getProjectTaskByProId(key);
    }

    @Override
    public Boolean getLeaderIdByProId(String proId, String userId) {
        Long key = Long.parseLong(proId);
        Integer res = projectMapper.getLeaderIdByProId(key);
        return String.valueOf(res).equals(userId)? true: false;
    }

    public PageInfo getPageInfo(PageRequest pageRequest) {
        int pageNum = Integer.parseInt(pageRequest.getPageNum());
        int pageSize = Integer.parseInt(pageRequest.getPageSize());
        PageHelper.startPage(pageNum, pageSize);
        List<Project> projects = projectMapper.selectAll();
        return new PageInfo<>(projects);
    }
}
