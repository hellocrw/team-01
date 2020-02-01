package crw.bishe.team.controller;

import crw.bishe.team.entity.UserRoles;
import crw.bishe.team.service.UserRolesService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("用户注册功能")
    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestParam("username") String username, @RequestParam("password") String password){
        String res = userDetailsService.register(username, password);
        return new ResponseEntity<>(new Result(200, res), HttpStatus.OK);
    }

    @ApiOperation("用户登录功能")
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody UserRoles userRoles){
        return null;
    }

}
