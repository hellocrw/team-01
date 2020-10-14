package crw.bishe.team.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqUtils {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        // 连接主机
        connectionFactory.setHost("120.79.191.236");
        // 设置端口
        connectionFactory.setPort(5672);
        // 设置虚拟主机
        connectionFactory.setVirtualHost("/ems");
        // 设置虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    // 定义提供创建连接对象的方法
    public static Connection getconnection(){
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭通道和关闭连接工具方法
    public static void closeConnectionAndChanel(Channel channel, Connection conn){
        try {
            if (channel!=null) channel.close();
            if (conn!=null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
