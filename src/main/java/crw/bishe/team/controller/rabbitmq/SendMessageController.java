package crw.bishe.team.controller.rabbitmq;

import io.swagger.annotations.Api;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 简单的接口进行消息推送（根据需求可以改为定时任务等等，具体看需求）
 */
@Api(tags = {"消息队列"})
@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;   //使用RabbitTemplate,提供了接收/发送等等方法

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "testMessage hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String , Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        // 将消息携带绑定键值，发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "OK";
    }
}
