package crw.bishe.team.service;

import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.mapper.UserTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTeamServiceImpl implements UserTeamService {

    @Autowired
    private UserTeamMapper userTeamMapper;

    @Override
    public List<UserTeamDto> getUserByTeamId(String teamId) {
        Long key = Long.parseLong(teamId);
        return userTeamMapper.getUserByTeamId(key);
    }
}
