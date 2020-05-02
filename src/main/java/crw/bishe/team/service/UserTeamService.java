package crw.bishe.team.service;

import crw.bishe.team.dto.UserTeamDto;

import java.util.List;

public interface UserTeamService {
    List<UserTeamDto> getUserByTeamId(String teamId);

    /**
     * 保存用户团队关联表信息
     * @param userTeamDto
     */
    void create(UserTeamDto userTeamDto);

    /**
     * 删除
     * @param teamId
     * @return
     */
    Integer deleteByTeamId(String teamId);

    /**
     * 根据主键删除
     * @param utId
     * @return
     */
    Integer deleteByUtId(String utId);
}
