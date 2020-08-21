package crw.bishe.team.controller.user;

import crw.bishe.team.dto.UserDto;
import crw.bishe.team.dto.UserRolesDto;
import crw.bishe.team.service.UserInfoService;
import crw.bishe.team.service.UserRolesService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description Description 用户管理
 * @Author crw
 * @Date Created in 2020/1/19 0019
 * @Time 13:58
 */
@Api(tags = {"用户信息管理"})
@RequestMapping("/api/user")
@RestController
@Log4j2
public class UserInfoController {

    private final UserInfoService usersService;
    private UserRolesService userRolesService;

    @Autowired
    public UserInfoController(UserInfoService usersService, UserRolesService userRolesService){
        this.usersService = usersService;
        this.userRolesService = userRolesService;
    }


    @ApiOperation("用户注册功能")
    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestBody UserRolesDto userRolesDto){
        String res = userRolesService.register(userRolesDto);
        return new ResponseEntity<>(new Result(200, res), HttpStatus.OK);
    }

    @ApiOperation(value = "查找所有用户信息")
    @GetMapping("/all")
    public ResponseEntity<Result<UserDto>> findAll(){
        List<UserDto> userDtos = usersService.findAll();
        return new ResponseEntity<>(new Result(200,"处理成功",userDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "增加用户信息")
    @PostMapping("")
    public ResponseEntity<Result> create(
            @ApiParam(value = "用户信息") @RequestBody @Validated UserDto userDto){
        int res = usersService.create(userDto);
        if (res > 0) {
            return new ResponseEntity(new Result<>(200, "处理成功"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new Result<>("处理失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "修改用户信息")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Result> update(@ApiParam(value = "用户ID") @PathVariable(name = "id") String id,
                                         @ApiParam(value = "用户信息", required = true) @RequestBody @Validated UserDto userDto){
        if(id == null ){
            return new ResponseEntity<>(new Result("更新数据不正确"), HttpStatus.METHOD_NOT_ALLOWED);
        }
        int res = usersService.update(userDto,id);
        if(res <= 0){
            return new ResponseEntity<>(new Result("错误"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Result(200,"处理成功"),HttpStatus.OK);
    }

    @ApiOperation(value = "删除用户信息")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Result> delete(
            @ApiParam(value = "用户信息ID") @PathVariable(name = "id") String id){
        int res = usersService.delete(id);
        if (res > 0){
            return new ResponseEntity(new Result<>(200,"处理成功"),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result("错误"), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "获取管理员基本信息")
    @GetMapping("/getAdminInfo")
    public ResponseEntity<Result> getAdminInfo(){
        List<UserDto> userDtos = usersService.getAdminInfo();
        return new ResponseEntity<>(new Result(200, "OK", userDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "获取用户基本信息")
    @GetMapping("/getUserInfo")
    public ResponseEntity<Result> getUserInfo(){
        List<UserDto> userDtos = usersService.getUserInfo();
        return new ResponseEntity<>(new Result(200, "OK", userDtos), HttpStatus.OK);
    }

    @ApiOperation(value = "通过团队ID获取队长信息")
    @GetMapping("/getLeaderByTeamId/{teamId}")
    public ResponseEntity<Result> getLeaderByTeamId(@PathVariable(name = "teamId") String teamId){
        UserDto userDto = usersService.getLeaderByTeamId(teamId);
        return new ResponseEntity<>(new Result(200, "OK", userDto), HttpStatus.OK);
    }
}
