package crw.bishe.team.service;

import crw.bishe.team.dto.UserDto;

import java.util.List;
import java.util.Map;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 13:48
 */
public interface UserInfoService {
    /**
     * 增加用户信息
     * @param userDto
     * @return
     */
    int create(UserDto userDto);

    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改用户信息
     * @param userDto
     * @return
     */
    int update(UserDto userDto, String id);


    /**
     * 查找所有用户信息
     * @return
     */
    List<UserDto> findAll();

    /**
     * 根据用户ID获取用户信息
     * @param userId
     * @return
     */
    UserDto getUserInfoByUserId(String userId);

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    UserDto getUserInfoByUserName(String userName);

    /**
     * 获取管理员信息
     * @return
     */
    List<UserDto> getAdminInfo();

    /**
     * 获取用户信息
     * @return
     */
    List<UserDto> getUserInfo();

    /**
     * 通过团队ID获取队长信息
     * @param teamId
     * @return
     */
    UserDto getLeaderByTeamId(String teamId);


}
