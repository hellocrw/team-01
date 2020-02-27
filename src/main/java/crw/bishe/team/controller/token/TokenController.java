package crw.bishe.team.controller.token;

import crw.bishe.team.config.JwtConfig;
import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.service.UserRolesService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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

    @ApiOperation("使用账号密码获取Token")
    @PostMapping("/getToken")
    public ResponseEntity<Result> getToken(@PathParam("username") String username, @PathParam("password") String password){
        // 模拟数据库
//        if (userRoles.getUsername() != "admin" && userRoles.getPassword() != "123456"){
//            return new ResponseEntity<>(new Result("用户名或密码错误"),HttpStatus.OK);
//        }
        Map<String, String> res = new HashMap<>();
        String token = jwtConfig.getToken(username+password);
        if (!StringUtils.isEmpty(token)){
            res.put("token", token);
            // 获取当前登录时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
            res.put("loginTime", simpleDateFormat.format(new Date()));

            /**
             * 模仿数据库，根据用户名查看用户ID
             */
            res.put("userId", "1");
        }
        res.put("username", username);
        return new ResponseEntity<>(new Result(200,"ok", res), HttpStatus.OK);
    }

}
