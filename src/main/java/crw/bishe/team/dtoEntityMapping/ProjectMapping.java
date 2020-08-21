package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.ProjectDto;
import crw.bishe.team.dto.TeamProDto;
import crw.bishe.team.entity.Project;

import java.util.List;
import java.util.Map;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 16:59
 */
public interface ProjectMapping {

    /**
     * 将dto转为entity
     * @param projectDto
     * @return entity
     */
    Project toEntity(ProjectDto projectDto);

    /**
     * 将entity 转为 Dto
     * @param project
     * @return dto
     */
    ProjectDto toDto(Project project);

}
