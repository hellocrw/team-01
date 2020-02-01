package crw.bishe.team.service;

import crw.bishe.team.dto.ProjectDto;

import java.util.List;
import java.util.Map;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 17:11
 */
public interface ProjectService {
    /**
     * 增加项目信息
     * @param projectDto
     * @return
     */
    int create(ProjectDto projectDto);

    /**
     * 根据ID删除项目信息
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改项目信息
     * @param projectDto
     * @return
     */
    int update(ProjectDto projectDto, String id);


    /**
     * 查找所有项目信息
     * @return
     */
    List<ProjectDto> findAll();

    public List<Map> getMyProList(String team_id);
}