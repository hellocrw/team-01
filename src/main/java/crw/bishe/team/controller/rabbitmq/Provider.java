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

    @GetMapping("/dirctProvider")
    public void directMessage(){
        rabbitTemplate.convertAndSend("hello", "hello world");
    }
}
