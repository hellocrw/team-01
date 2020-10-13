package crw.bishe.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *@SpringCloudApplication注解==>
 *      @EnableCircuitBreaker：开启熔断
 *      @SpringBootApplication：声明启动类
 *      @EnableDiscoveryClien：声明Eureka客户端
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})  // 排除掉spirng security身份认证
@ServletComponentScan
@EnableCaching
@EnableAspectJAutoProxy
@EnableFeignClients    //声明这是一个EnableFeignClients的客户端，hystrix服务熔断必须要有
@EnableCircuitBreaker    // 开启 Hystrix 熔断
@MapperScan("crw.bishe.team.mapper")
@EnableEurekaClient
public class TeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamApplication.class, args);
    }

}
