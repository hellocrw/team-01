package crw.bishe.team.service;

import crw.bishe.team.dto.TeamTypeDto;
import crw.bishe.team.dto.UniversityDto;
import crw.bishe.team.entity.TeamType;
import crw.bishe.team.mapper.TeamTypeMapper;
import crw.bishe.team.mapper.UniversityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 15:33
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private TeamTypeMapper teamTypeMapper;

    @Autowired
    private UniversityMapper universityMapper;

    @Override
    public List<TeamTypeDto> getTeamType() {
        List<TeamTypeDto> teamTypeDtos = teamTypeMapper.selectTeamType();
        return teamTypeDtos;
    }

    @Override
    public List<UniversityDto> getUniversity() {
        List<UniversityDto> universityDtos = universityMapper.selectUniversityAll();
        return universityDtos;
    }
}
