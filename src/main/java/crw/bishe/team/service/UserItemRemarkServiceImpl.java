package crw.bishe.team.service;

import crw.bishe.team.mapper.UserItemRemarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserItemRemarkServiceImpl implements UserItemRemarkService, Comparable<Map<String, Object>> {

    @Autowired
    private UserItemRemarkMapper userItemRemarkMapper;

    @Override
    public List<Map<String, Long>> getTeamTypeNum(String userId) {
        Long key = Long.parseLong(userId);
        return userItemRemarkMapper.getTeamTypeNum(key);
    }

    @Override
    public int compareTo(Map<String, Object> o) {
        return 0;
    }
}
