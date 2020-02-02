package crw.bishe.team.dtoEntityMapping;

import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.entity.UserRoles;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/2/2 0002
 * @Time 2:24
 */
public interface UserRolesMapping {
    /**
     * 将dto转为entity
     * @param userRolesDto
     * @return entity
     */
    UserRoles toEntity(UserRolesDto userRolesDto);

    /**
     * 将entity 转为 Dto
     * @param userRoles
     * @return dto
     */
    UserRolesDto toDto(UserRoles userRoles);
}
