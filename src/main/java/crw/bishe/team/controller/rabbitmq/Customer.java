package crw.bishe.team.controller.rabbitmq;

import io.swagger.annotations.Api;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"消息消费者"})
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class Customer {

    @GetMapping("receivel")
    @RabbitHandler
    public void receivel(String message){
        System.out.println("message = " + message);
    }

}
