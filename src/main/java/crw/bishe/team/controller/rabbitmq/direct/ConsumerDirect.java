package crw.bishe.team.controller.rabbitmq.direct;

import com.rabbitmq.client.*;
import crw.bishe.team.utils.RabbitmqUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerDirect {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        /*ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("120.79.191.236");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
        connectionFactory.setVirtualHost("/ems");
        // 获取连接对象
        Connection connection = connectionFactory.newConnection();*/
        Connection connection = RabbitmqUtils.getconnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 通道绑定对象
        channel.queueDeclare("hello", true, false, false, null);
        // 消费消息 1. 队列名称 2. 开始消息的自动确认机制 3. 雄安飞消息的回调接口
        channel.basicConsume("hello",true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("new String(body) = "+new String(body));
            }
        });
    }
}
