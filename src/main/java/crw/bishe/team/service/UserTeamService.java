package crw.bishe.team.service;

import crw.bishe.team.dto.UserTeamDto;

import java.util.List;

public interface UserTeamService {
    List<UserTeamDto> getUserByTeamId(String teamId);
}
