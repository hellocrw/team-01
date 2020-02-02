package crw.bishe.team.service;

import crw.bishe.team.mapper.DictionaryMapper;
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
    @Override
    public String[] getProType() {
        String proType = dictionaryMapper.getProType();
        String[] proTypes = proType.split(",");
        return proTypes;
    }

    @Override
    public String[] getUniversity() {
        String university = dictionaryMapper.getUniversity();
        String[] universities = university.split(",");
        return universities;
    }
}
