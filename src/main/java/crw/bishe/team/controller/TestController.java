package crw.bishe.team.controller;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description Description 测试类
 * @Author crw
 * @Date Created in 2019/12/20 0020
 * @Time 14:00
 */
@Api(tags = {"测试接口"})
@RequestMapping("/api/test")
@RestController
@ResponseBody
public class TestController {

    /**
     * 权限ADMIN
     * @return
     */
    @GetMapping(value = "/out")
//    @PreAuthorize("hasRole('ADMIN')")
    public String logout(){
        return "退出成功";
    }

    /**
     * 需要登录，但不需要角色
     * @return
     */
    @GetMapping(value = "/fail")
    @PreAuthorize("isAuthenticated()")
    public String fail(){
        return "失败";
    }
}
