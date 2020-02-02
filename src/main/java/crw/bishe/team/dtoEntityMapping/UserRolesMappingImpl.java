package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.entity.UserRoles;
import org.springframework.stereotype.Component;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 2:26
 */
@Component("userRolesMapping")
public class UserRolesMappingImpl implements UserRolesMapping {
    @Override
    public UserRoles toEntity(UserRolesDto userRolesDto) {
        if (userRolesDto == null){
            return null;
        }
        UserRoles userRoles = new UserRoles();
        if (userRolesDto.getId() == null || userRolesDto.getId() == ""){
            userRoles.setId(null);
        }else{
            userRoles.setId(Long.parseLong(userRolesDto.getId()));
        }
        userRoles.setUsername(userRolesDto.getUsername());
        userRoles.setPassword(userRolesDto.getPassword());
        userRoles.setAuth(userRolesDto.getAuth());
        return userRoles;
    }

    @Override
    public UserRolesDto toDto(UserRoles userRoles) {
        if (userRoles == null){
            return null;
        }
        UserRolesDto userRolesDto = new UserRolesDto();
        userRolesDto.setId(String.valueOf(userRoles.getId()));
        userRolesDto.setUsername(userRoles.getUsername());
        userRolesDto.setPassword(userRoles.getPassword());
        userRolesDto.setAuth(userRoles.getAuth());
        return userRolesDto;
    }
}
