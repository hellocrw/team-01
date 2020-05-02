package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.entity.Team;
import crw.bishe.team.entity.UserTeam;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 14:44
 */
public interface TeamMapping {
    /**
     * 将团队dto转为Entity
     * @param teamDto
     * @return team
     */
    Team toEntity(TeamDto teamDto);

    /**
     * 将团队entity转为dto
     * @param team
     * @return teamDto
     */
    TeamDto toDto(Team team);


//    MyTeamDto toEntity(Team team);

}
