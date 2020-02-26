package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.TeamDto;
import crw.bishe.team.entity.Team;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 14:46
 */
@Component("teamMapping")
public class TeamMappingImpl implements TeamMapping {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Team toEntity(TeamDto teamDto) {
        if(teamDto == null ){
            return null;
        }
        Team team = new Team();
        if(teamDto.getTeamId() == null || teamDto.getTeamId() == ""){
            team.setTeamId(null);
        }else{
            team.setTeamId(Long.parseLong(teamDto.getTeamId()));
        }
        team.setTeamName(teamDto.getTeamName());
        team.setLeaderId(Long.parseLong(teamDto.getLeaderId()));
        team.setTeamDescribe(teamDto.getTeamDescribe());
        team.setTeamType(teamDto.getTeamType());
        team.setTeamNumber(Integer.parseInt(teamDto.getTeamNumber()));
        team.setTeamDate(Date.valueOf(teamDto.getTeamDate()));
        team.setStatus(Byte.parseByte(teamDto.getStatus()));
        team.setStaff(teamDto.getStaff());
        team.setTeamNature(teamDto.getTeamNature());
        return team;
    }

    @Override
    public TeamDto toDto(Team team) {
        if(team == null){
            return null;
        }
        TeamDto teamDto = new TeamDto();
        teamDto.setTeamId(String.valueOf(team.getTeamId()));
        teamDto.setTeamName(team.getTeamName());
        teamDto.setLeaderId(String.valueOf(team.getLeaderId()));
        teamDto.setTeamDescribe(team.getTeamDescribe());
        teamDto.setTeamType(team.getTeamType());
        teamDto.setTeamNumber(String.valueOf(team.getTeamNumber()));
        teamDto.setTeamDate(simpleDateFormat.format(team.getTeamDate()));
        teamDto.setStatus(String.valueOf(team.getStatus()));
        teamDto.setStaff(team.getStaff());
        teamDto.setTeamNature(team.getTeamNature());
        return teamDto;
    }
}
