package crw.bishe.team.controller.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import crw.bishe.team.utils.RabbitmqUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProviderDirect {

    // 生产消息
    @Test
    public void sendMessage() throws IOException, TimeoutException {
        /*//创建连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 连接主机
        connectionFactory.setHost("120.79.191.236");
        // 设置端口
        connectionFactory.setPort(5672);
        // 设置虚拟主机
        connectionFactory.setVirtualHost("/ems");
        // 设置虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();*/
        // 通过工具类获取连接
        Connection connection = RabbitmqUtils.getconnection();

        //创建通道
        Channel channel = connection.createChannel();
        // 通道绑定对应的消息队列
        //参数1: 是否持久化  参数2:是否独占队列   参数3:是否自动删除    参数4:其他属性
        channel.queueDeclare("hello",true,false,false,null);
        // 发布消息 1. 交换机名称  2.队列名称  3. 传递消息的额外设置  4.消息的具体内容
        channel.basicPublish("","hello", null,"hello rabbitmq".getBytes());

//        channel.close();
//        connection.close();
        RabbitmqUtils.closeConnectionAndChanel(channel, connection);
    }
}
