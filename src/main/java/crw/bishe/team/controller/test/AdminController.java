package crw.bishe.team.controller.test;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"管理员测试接口"})
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @GetMapping("/login")
    public String Login(){
        return "管理员";
    }
}
