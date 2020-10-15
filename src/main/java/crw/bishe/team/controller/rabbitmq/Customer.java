package crw.bishe.team.controller.rabbitmq;

import io.swagger.annotations.Api;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"消息消费者"})
public class Customer {

    // hello world模型
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    @RabbitHandler
    public void receivel(String message){
        System.out.println("message = " + message);
    }

    // queue work模型
    @RabbitListener(queuesToDeclare = @Queue("queue work"))
    public void receivel1(String message) {
        System.out.println("work message1 = " + message);
    }

    // queue work模型
    @RabbitListener(queuesToDeclare = @Queue("queue work"))
    public void receivel2(String message) {
        System.out.println("work message2 = " + message);
    }

    // Fanout 广播模型
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "logs", type = "fanout")
    ))
    public void fanoutCustomer1(String message){
        System.out.println("fanoutCustomer1 => " + message);
    }

    // Fanout 广播模型
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "logs", type = "fanout")
    ))
    public void fanoutCustomer2(String message){
        System.out.println("fanoutCustomer2 => " + message);
    }

    // Route 路由模型
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(),
                    key = {"info", "error"},
                    exchange = @Exchange(type = "direct", name="directs")
            )
    })
    public void routeCostomer1(String message){
        System.out.println("routeCostomer1 => " + message);
    }

    // Route 路由模型
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(),
                    key = {"error"},
                    exchange = @Exchange(type = "direct", name="directs")
            )
    })
    public void routeCostomer2(String message){
        System.out.println("routeCostomer2 => " + message);
    }

}
