package crw.bishe.team.service;

import crw.bishe.team.dto.UserDto;
import crw.bishe.team.dtoEntityMapping.UserMapping;
import crw.bishe.team.entity.UserInfo;
import crw.bishe.team.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 13:49
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoMapper userInfoMapper;
    private final UserMapping userMapping;

    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userMapper, UserMapping userMapping){
        this.userInfoMapper = userMapper;
        this.userMapping = userMapping;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(UserDto userDto) {
        if (userDto == null){
            return 0;
        }
        return userInfoMapper.insert(userMapping.toEntity(userDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(String id) {
        Long key = Long.parseLong(id);
        return userInfoMapper.deleteByPrimaryKey(key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(UserDto userDto, String id) {
        if(id == null){
            return 0;
        }
        Long key = Long.parseLong(id);
        if(userInfoMapper.selectByPrimaryKey(key) == null){
            return 0;
        }
        return userInfoMapper.updateByPrimaryKey(userMapping.toEntity(userDto));
    }

    @Override
    public List<UserDto> findAll() {
        List<UserInfo> users = userInfoMapper.selectAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = userMapping.toDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }
}
