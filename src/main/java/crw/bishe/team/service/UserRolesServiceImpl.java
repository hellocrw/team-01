package crw.bishe.team.service;

import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.dtoEntityMapping.UserRolesMapping;
import crw.bishe.team.entity.UserInfo;
import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.mapper.UserInfoMapper;
import crw.bishe.team.mapper.UserRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @description Description 自定义认证用户获取服务类
 * @Author crw
 * @create 2020/1/18
 * @Time 16:11
 **/
@Service
public class UserRolesServiceImpl implements UserRolesService  {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRolesMapping userRolesMapping;

    /**
     * 用户注册
     * @param userRolesDto
     * @return
     */
    @Override
    public String register(UserRolesDto userRolesDto) {
        UserRoles userRoles = userRolesMapping.toEntity(userRolesDto);
        if(userRoles.getUsername() == null || userRoles.getPassword() == null){
            return "用户名或密码不能为空";
        }
        if(userRolesMapper.findByUserName(userRoles.getUsername()) != null){
            return "用户名已经存在";
        }
        // 密码加密
        String pass = BCrypt.hashpw(userRoles.getPassword(), BCrypt.gensalt());
        userRoles.setPassword(pass);
        userRoles.setAuth("USER");
        userRolesMapper.userRegister(userRoles);

        // TODO
        /*临时默认用户的基本信息*/
        UserInfo userInfo = new UserInfo();
        userInfo.setRoleId(userRoles.getId());
        userInfo.setUserName(userRoles.getUsername());
        userInfo.setUserAvatar("https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png");
        userInfo.setGender(new Byte("0"));
        userInfo.setUniversity("null");
        userInfo.setCollege("null");
        userInfo.setProfession("null");
        userInfo.setGrade("null");
        userInfo.setUserClass("null");
        userInfo.setUserNo(0);
        userInfo.setUserTel("null");
        userInfo.setEmail("null");
        userInfo.setAbility("null");
        userInfoMapper.insert(userInfo);

        return "用户注册成功";
    }

    @Override
    public String getAuth(String username) {
        return userRolesMapper.getAuth(username);
    }
}
