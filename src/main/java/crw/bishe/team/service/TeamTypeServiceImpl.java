package crw.bishe.team.service;

import crw.bishe.team.mapper.TeamTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeamTypeServiceImpl implements TeamTypeService {

    @Autowired
    private TeamTypeMapper teamTypeMapper;

    @Override
    public String getValueByKey(String key) {
        Long k = Long.parseLong(key);
        return this.teamTypeMapper.getValueByKey(k);
    }

    @Override
    public List<Map<String, Object>> getTeamTypeNumber(String userId) {
        Long key = Long.parseLong(userId);
        return teamTypeMapper.getTeamTypeNumber(key);
    }

    @Override
    public List<Map<String, Object>> getProTypeNumber(String userId) {
        Long key = Long.parseLong(userId);
        return teamTypeMapper.getProTypeNumber(key);
    }

    @Override
    public List<Map<String, Object>> getTaskTypeNumber(String userId) {
        Long key = Long.parseLong(userId);
        return teamTypeMapper.getTaskTypeNumber(key);
    }

    @Override
    public List<Map<String, Object>> getTeamAnalysis() {
        return teamTypeMapper.getTeamAnalysis();
    }

    @Override
    public List<Map<String, Object>> getUserAnalysis() {
        return teamTypeMapper.getUserAnalysis();
    }
}
