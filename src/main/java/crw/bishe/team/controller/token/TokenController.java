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
    public ResponseEntity<Result> getToken(@RequestBody UserRoles userRoles){
        // 模拟数据库
//        if (userRoles.getUsername() != "admin" && userRoles.getPassword() != "123456"){
//            return new ResponseEntity<>(new Result("用户名或密码错误"),HttpStatus.OK);
//        }
        Map<String, String> res = new HashMap<>();
        String token = jwtConfig.getToken(userRoles.getUsername()+userRoles.getPassword());
        if (!StringUtils.isEmpty(token)){
            res.put("token", token);
        }
        res.put("userName", userRoles.getUsername());
        return new ResponseEntity<>(new Result(200,"ok", res), HttpStatus.OK);
    }

}
