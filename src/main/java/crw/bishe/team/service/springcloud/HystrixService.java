package crw.bishe.team.service.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("ORDER80")
public interface HystrixService {

    /**
     * 服务调用测试方法
     * @return
     */
    @GetMapping(value = "/demo01")
    public String demo();

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
