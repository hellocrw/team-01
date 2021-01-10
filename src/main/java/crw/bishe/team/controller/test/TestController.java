package crw.bishe.team.controller.test;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"测试控制器"})
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/demo01")
    public String Login(){
        return "测试";
    }
}
