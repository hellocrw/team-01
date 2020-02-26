package crw.bishe.team.service;

import crw.bishe.team.dto.TeamTypeDto;
import crw.bishe.team.dto.UniversityDto;
import crw.bishe.team.entity.TeamType;

import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 15:32
 */
public interface DictionaryService {
    /**
     * 获取团队类型
     * @return
     */
    List<TeamTypeDto> getTeamType();

    /**
     * 获取学校信息
     * @return
     */
    List<UniversityDto> getUniversity();
}
