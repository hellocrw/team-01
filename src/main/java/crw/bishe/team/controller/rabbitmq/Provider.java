package crw.bishe.team.controller.rabbitmq;

import io.swagger.annotations.Api;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"消息提供者"})
public class Provider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // hello world模型
    @GetMapping("/dirctProvider")
    public void directMessage(){
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    // queue work模型
    @GetMapping("/queueWork")
    public void queueWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("queue work", "hello world");
        }
    }

    // Fanout 广播模型
    @GetMapping("/fanout")
    public void testFanout() throws InterruptedException{
        rabbitTemplate.convertAndSend("logs", "", "这事日志广播");
    }

    // Route 路由模型
    @GetMapping("/routeProdiver")
    public void routeProdiver(){
        rabbitTemplate.convertAndSend("directs","error","error 的日志信息");
    }
}
