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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectMapping projectMapping){
        this.projectMapper = projectMapper;
        this.projectMapping = projectMapping;
    }
    @Override
    public int create(ProjectDto projectDto) {
        if(projectDto == null ){
            return 0;
        }
        return projectMapper.insert(projectMapping.toEntity(projectDto));
    }

    @Override
    public int delete(String id) {
        if(id == null){
            return 0;
        }
        Long key = Long.parseLong(id);
        return projectMapper.deleteByPrimaryKey(key);
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

    public PageInfo getPageInfo(PageRequest pageRequest) {
        int pageNum = Integer.parseInt(pageRequest.getPageNum());
        int pageSize = Integer.parseInt(pageRequest.getPageSize());
        PageHelper.startPage(pageNum, pageSize);
        List<Project> projects = projectMapper.selectAll();
        return new PageInfo<>(projects);
    }
}
