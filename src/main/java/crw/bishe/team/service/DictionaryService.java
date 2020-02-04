package crw.bishe.team.service;

import crw.bishe.team.dto.ProTypeDto;
import crw.bishe.team.dto.UniversityDto;

import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 15:32
 */
public interface DictionaryService {
    List<ProTypeDto> getProType();
    List<UniversityDto> getUniversity();
}
