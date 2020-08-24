package crw.bishe.team.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description Description
 * @Author crw
 * @Date Created in 2020/1/3 0003
 * @Time 22:23
 */
@FeignClient("ORDER80")
@Component
public interface TestService {

    /**
     * 服务调用测试方法
     * @return
     */
    @GetMapping(value = "/demo01")
    public String demo();

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
