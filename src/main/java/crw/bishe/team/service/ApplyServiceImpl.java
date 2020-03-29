package crw.bishe.team.service;

import crw.bishe.team.dto.ApplyDto;
import crw.bishe.team.dtoEntityMapping.ApplyMapping;
import crw.bishe.team.entity.Apply;
import crw.bishe.team.mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/4 0004
 * @Time 0:47
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private ApplyMapping applyMapping;

    @Override
    public int create(ApplyDto applyDto) {
        Apply apply = applyMapping.toEntity(applyDto);
        return applyMapper.insert(apply);
    }

    @Override
    public List<ApplyDto> getApplyByUserId(String userId) {
        Long key = Long.parseLong(userId);
        return applyMapper.getApplyByUserId(key);
    }
}
