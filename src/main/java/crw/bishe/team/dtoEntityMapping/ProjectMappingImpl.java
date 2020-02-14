package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.entity.Project;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;


/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 17:01
 */
@Component("projectMapping")
public class ProjectMappingImpl implements ProjectMapping {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Project toEntity(ProjectDto projectDto) {
        if(projectDto == null){
            return null;
        }
        Project project = new Project();
        if(projectDto.getProId() == null || projectDto.getProId() == ""){
            project.setTeamId(null);
        }else{
            project.setProId(Long.parseLong(projectDto.getProId()));
        }
        project.setProName(projectDto.getProName());
        project.setLeaderName(projectDto.getLeaderName());
        project.setProDescribe(projectDto.getProDescribe());
        project.setProDate(Date.valueOf(projectDto.getProDate()));
        project.setProStartTime(Date.valueOf(projectDto.getProStartTime()));
        project.setProEndTime(Date.valueOf(projectDto.getProEndTime()));
        project.setProStatus(projectDto.getProStatus());
        project.setTeamId(projectDto.getTeamId());
        project.setStaffList(projectDto.getStaffList());
        project.setProType(projectDto.getProType());
        project.setProCurrentNum(Integer.parseInt(projectDto.getProCurrentNum()));
        project.setProLimiedNum(Integer.parseInt(projectDto.getProLimiedNum()));
        project.setNumber(Integer.parseInt(projectDto.getNumber()));
        project.setSeeNum(Integer.parseInt(projectDto.getSeeNum()));
        project.setStaff(projectDto.getStaff());
        return project;
    }

    @Override
    public ProjectDto toDto(Project project) {
        if(project == null){
            return null;
        }
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProId(String.valueOf(project.getProId()));
        projectDto.setProName(project.getProName());
        projectDto.setLeaderName(project.getLeaderName());
        projectDto.setProDescribe(project.getProDescribe());
        projectDto.setProDate(simpleDateFormat.format(project.getProDate()));
        projectDto.setProStartTime(simpleDateFormat.format(project.getProStartTime()));
        projectDto.setProEndTime(simpleDateFormat.format(project.getProEndTime()));
        projectDto.setProStatus(project.getProStatus());
        projectDto.setTeamId(project.getTeamId());
        projectDto.setStaffList(project.getStaffList());
        projectDto.setProType(project.getProType());
        projectDto.setProCurrentNum(String.valueOf(project.getProCurrentNum()));
        projectDto.setProLimiedNum(String.valueOf(project.getProLimiedNum()));
        projectDto.setNumber(String.valueOf(project.getNumber()));
        projectDto.setSeeNum(String.valueOf(project.getSeeNum()));
        projectDto.setStaff(project.getStaff());
        return projectDto;
    }

}
