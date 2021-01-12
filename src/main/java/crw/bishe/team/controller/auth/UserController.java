package crw.bishe.team.controller.auth;

import crw.bishe.team.dto.AlterPasswordDto;
import crw.bishe.team.dto.UserRegisterDto;
import crw.bishe.team.service.auth.IAuthUserService;
import crw.bishe.team.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"用户控制器"})
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IAuthUserService authUserService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ResponseEntity<Result<String>> register(@RequestBody UserRegisterDto userRegisterDto){
        return new ResponseEntity<>(new Result<>(200, "success", authUserService.register(userRegisterDto)), HttpStatus.OK);
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/alterPassword")
    public ResponseEntity<Result<String>> alterPassword(@RequestBody AlterPasswordDto alterPasswordDto, HttpServletRequest request){
        return new ResponseEntity<>(new Result<>(200, "success", authUserService.alterPassword(alterPasswordDto, request)), HttpStatus.OK);
    }
}
