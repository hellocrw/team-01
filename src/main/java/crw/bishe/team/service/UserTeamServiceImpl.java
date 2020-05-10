package crw.bishe.team.service;

import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.dtoEntityMapping.UserTeamMapping;
import crw.bishe.team.entity.UserTeam;
import crw.bishe.team.mapper.UserTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTeamServiceImpl implements UserTeamService {

    @Autowired
    private UserTeamMapper userTeamMapper;

    @Autowired
    private UserTeamMapping userTeamMapping;

    @Override
    public List<UserTeamDto> getUserByTeamId(String teamId) {
        Long key = Long.parseLong(teamId);
        return userTeamMapper.getUserByTeamId(key);
    }

    @Override
    public void create(UserTeamDto userTeamDto) {
        UserTeam userTeam = userTeamMapping.toEntity(userTeamDto);
        userTeamMapper.insert(userTeam);
    }

    @Override
    public Integer deleteByTeamId(String teamId) {
        Long key = Long.parseLong(teamId);
        return userTeamMapper.deleteByTeamId(key);
    }

    @Override
    public Integer deleteByUtId(String utId) {
        Long key = Long.parseLong(utId);
        return userTeamMapper.deleteByPrimaryKey(key);
    }

    @Override
    public Integer existInTeam(String userId, String teamId) {
        Long key1 = Long.parseLong(userId);
        Long key2 = Long.parseLong(teamId);
        return userTeamMapper.existInTeam(key1, key2);
    }
}
