package crw.bishe.team.service;

import crw.bishe.team.dto.ProTypeDto;
import crw.bishe.team.dto.UniversityDto;
import crw.bishe.team.entity.ProType;
import crw.bishe.team.mapper.DictionaryMapper;
import crw.bishe.team.mapper.ProTypeMapper;
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
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private ProTypeMapper proTypeMapper;

    @Autowired
    private UniversityMapper universityMapper;

    @Override
    public List<ProTypeDto> getProType() {
        List<ProTypeDto> proTypes = proTypeMapper.selectProTypeAll();
        return proTypes;
    }

    @Override
    public List<UniversityDto> getUniversity() {
        List<UniversityDto> universityDtos = universityMapper.selectUniversityAll();
        return universityDtos;
    }
}
