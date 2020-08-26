package crw.bishe.team.controller.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import crw.bishe.team.service.springcloud.HystrixService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = {"服务熔断"})
@RequestMapping("/hystrix")
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    /**
     * 服务调用接口
     * @return
     */
    @GetMapping("/a")
    public String openFeign(){
        return hystrixService.demo();
    }

    /**
     * 服务超时测试
     * @return
     */
    @GetMapping(value = "/feign/timeout")
//    @HystrixCommand(fallbackMethod = "hystrixFallback")
    @HystrixCommand
    public String paymentFeignTimeout(){
        return hystrixService.paymentFeignTimeout();
    }

    public String hystrixFallback(){
        return "温馨提醒：网络连接超时!!!";
    }

    public String defaultFallback(){
        return "网络提示您，您的请求已超时!!!";
    }

}
