package crw.bishe.team.controller;

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
@Api(tags = {"用户管理"})
@RequestMapping(value = "/api/security")
public class UserRolesController {

    @Autowired
    private UserRolesService userDetailsService;

    @Autowired
    private JwtConfig jwtConfig;

    @ApiOperation("用户注册功能")
    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestBody UserRolesDto userRolesDto){
        String res = userDetailsService.register(userRolesDto);
        return new ResponseEntity<>(new Result(200, res), HttpStatus.OK);
    }

    @ApiOperation("用户登录功能,获取Token")
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody UserRoles userRoles){
        Map<String, String> res = new HashMap<>();
        String token = jwtConfig.getToken(userRoles.getUsername()+userRoles.getPassword());
        if (!StringUtils.isEmpty(token)){
            res.put("token", token);
        }
        res.put("userName", userRoles.getUsername());
        return new ResponseEntity<>(new Result(200,"ok", res), HttpStatus.OK);
    }

}
