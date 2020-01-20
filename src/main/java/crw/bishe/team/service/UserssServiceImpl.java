package crw.bishe.team.service;

import crw.bishe.team.dto.UserDto;
import crw.bishe.team.dtoEntityMapping.UserMapping;
import crw.bishe.team.entity.Users;
import crw.bishe.team.mapper.UsersMapper;
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
public class UserssServiceImpl implements UsersService {

    private final UsersMapper usersMapper;
    private final UserMapping userMapping;

    @Autowired
    public UserssServiceImpl(UsersMapper userMapper, UserMapping userMapping){
        this.usersMapper = userMapper;
        this.userMapping = userMapping;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(UserDto userDto) {
        if (userDto == null){
            return 0;
        }
        return usersMapper.insert(userMapping.toEntity(userDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(String id) {
        Long key = Long.parseLong(id);
        return usersMapper.deleteByPrimaryKey(key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(UserDto userDto, String id) {
        if(id == null){
            return 0;
        }
        Long key = Long.parseLong(id);
        if(usersMapper.selectByPrimaryKey(key) == null){
            return 0;
        }
        return usersMapper.updateByPrimaryKey(userMapping.toEntity(userDto));
    }

    @Override
    public List<UserDto> findAll() {
        List<Users> users = usersMapper.selectAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = userMapping.toDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }
}
