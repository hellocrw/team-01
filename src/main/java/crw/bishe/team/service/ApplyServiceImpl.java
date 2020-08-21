package crw.bishe.team.service;

import crw.bishe.team.dto.ApplyDto;
import crw.bishe.team.dtoEntityMapping.ApplyMapping;
import crw.bishe.team.entity.Apply;
import crw.bishe.team.entity.UserTeam;
import crw.bishe.team.mapper.ApplyMapper;
import crw.bishe.team.mapper.UserTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    private UserTeamMapper userTeamMapper;

    @Autowired
    private ApplyMapping applyMapping;

    @Override
    @CacheEvict(cacheNames = "apply", allEntries = true)
    public int create(ApplyDto applyDto) {
        Apply apply = applyMapping.toEntity(applyDto);
        return applyMapper.insert(apply);
    }

    @Override
    @Cacheable(value = "apply", key = "#userId")
    public List<ApplyDto> getApplyByUserId(String userId) {
        Long key = Long.parseLong(userId);
        return applyMapper.getApplyByUserId(key);
    }

    @Override
    @Cacheable(value = "apply", key = "#userId")
    public List<ApplyDto> getEnqueueApply(String userId) {
        Long key = Long.parseLong(userId);
        return applyMapper.getEnqueueApply(key);
    }

    @Override
    @CacheEvict(cacheNames = "apply", allEntries = true)
    public Integer deleteByTeamId(String teamId) {
        Long key = Long.parseLong(teamId);
        return applyMapper.deleteByTeamId(key);
    }

    @Override
    @CacheEvict(cacheNames = "apply", allEntries = true)
    public Integer agreeApply(String applyId) {
        Long key = Long.parseLong(applyId);
        // 保存入队的团队和用户到用户团队关联表中
        Apply apply = applyMapper.selectByPrimaryKey(key);
        UserTeam userTeam = UserTeam.builder()
                .teamId(apply.getTeamId())
                .teamName(apply.getTeamName())
                .userId(apply.getUserId())
                .userName(apply.getUserName())
                .isLeader(Byte.parseByte("0"))
                .build();
        userTeamMapper.insert(userTeam);
        return applyMapper.agreeApply(key);
    }

    @Override
    @CacheEvict(cacheNames = "apply", allEntries = true)
    public Integer disagreeApply(String applyId) {
        Long key = Long.parseLong(applyId);
        return applyMapper.disagreeApply(key);
    }
}
