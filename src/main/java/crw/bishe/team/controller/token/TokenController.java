package crw.bishe.team.controller.token;

import crw.bishe.team.config.JwtConfig;
import crw.bishe.team.dto.UserDto;
import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.service.UserInfoService;
import crw.bishe.team.service.UserRolesService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/29 0029
 * @Time 21:18
 */
@RestController
@Api(tags = {"令牌管理"})
@RequestMapping(value = "/api/token")
public class TokenController {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserRolesService userRolesService;

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("使用账号密码获取Token")
    @PostMapping("/getToken")
    public ResponseEntity<Result> getToken(@RequestBody @Validated UserRolesDto userRolesDto){
        // 模拟数据库验证用户登录信息
//        if (username != "admin" && password != "123456"){
//            return new ResponseEntity<>(new Result("用户名或密码错误"),HttpStatus.OK);
//        }
//        TODO  如果登录成功
        UserDto userDto = userInfoService.getUserInfoByUserId("1");
        Map<String, Object> res = new HashMap<>();
        System.out.println(userRolesDto.getUsername() + " " + userRolesDto.getPassword());
        String token = jwtConfig.getToken(userRolesDto.getUsername()+userRolesDto.getPassword());
        if (!StringUtils.isEmpty(token)){
            res.put("token", token);
            // 获取当前登录时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
            res.put("loginTime", simpleDateFormat.format(new Date()));

            /**
             * 模仿数据库，根据用户名查询用户基本信息
             */
            res.put("userInfo", userDto);
            // 获取用户权限
            res.put("auth", userRolesService.getAuth(userRolesDto.getUsername()));
        }
        return new ResponseEntity<>(new Result(200,"ok", res), HttpStatus.OK);
    }

}
