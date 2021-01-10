package crw.bishe.team.controller.test;

import crw.bishe.team.entity.auth.AuthUser;
import crw.bishe.team.mapper.auth.AuthUserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"测试控制器"})
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private AuthUserMapper authUserMapper;

    @GetMapping("/demo01")
    public String Login(){
        return "测试";
    }

    @GetMapping("/getUser")
    public AuthUser getUser(@RequestParam("id") String id){
        return authUserMapper.getByNum(id);
    }
}
