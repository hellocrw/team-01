package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.UserTeamDto;
import crw.bishe.team.entity.UserTeam;
import org.springframework.stereotype.Component;

@Component("userTeamMapping")
public class UserTeamMappingImpl implements UserTeamMapping {
    @Override
    public UserTeam toEntity(UserTeamDto userTeamDto) {
        if (userTeamDto == null){
            return null;
        }
        // TODO
        UserTeam userTeam = UserTeam.builder().build();
        if (userTeamDto.getUtId() == null || userTeamDto.getUtId().equals("")){
            userTeam.setUtId(null);
        }
        userTeam.setUserId(Long.parseLong(userTeamDto.getUserId()));
        userTeam.setUserName(userTeamDto.getUserName());
        userTeam.setTeamId(Long.parseLong(userTeamDto.getTeamId()));
        userTeam.setTeamName(userTeamDto.getTeamName());
        userTeam.setIsLeader(Byte.parseByte(userTeamDto.getIsLeader()));
        return userTeam;
    }
}
