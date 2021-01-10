package crw.bishe.team.controller.test;

import crw.bishe.team.utils.LoginUserUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"管理员测试控制器"})
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @GetMapping("/login")
    public String Login(){
        String userId = LoginUserUtil.getUserId();
        System.out.println("当前登陆人：" + userId);
        return "管理员";
    }
}
