package crw.bishe.team.controller.test;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"权限测试类"})
@RequestMapping("/api/auth-test")
@RestController
public class AuthTestController {

    @GetMapping("/")
    public String login(){
        return "不需要权限";
    }

    @GetMapping("/needLogin")  // 需要登录才能访问
    @PreAuthorize("isAuthenticated()")
    public String needLogin(){
        return "需要登录";
    }

    @GetMapping("/needAdmin")
    @PreAuthorize("hasAuthority('ADMIN')")  // 基于方法的权限控制，拥有ADMIN权限才可以访问
    public String needAdmin(){
        return "需要管理员权限";
    }

    @GetMapping("/needUser")
    @PreAuthorize("hasAuthority('USER')")  // 基于方法的权限控制，拥有USER权限才可以访问
    public String needUser(){
        return "需要用户权限";
    }
}
