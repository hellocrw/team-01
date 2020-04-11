package crw.bishe.team.service;

import crw.bishe.team.mapper.TeamTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamTypeServiceImpl implements TeamTypeService {

    @Autowired
    private TeamTypeMapper teamTypeMapper;

    @Override
    public String getValueByKey(String key) {
        Long k = Long.parseLong(key);
        return this.teamTypeMapper.getValueByKey(k);
    }
}
