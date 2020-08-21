package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.entity.UserTeam;

public interface UserTeamMapping {
    /**
     * 转为实体类
     * @param userTeamDto
     * @return
     */
    UserTeam toEntity(UserTeamDto userTeamDto);
}
