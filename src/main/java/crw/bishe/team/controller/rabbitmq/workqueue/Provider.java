package crw.bishe.team.controller.rabbitmq.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import crw.bishe.team.utils.RabbitmqUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getconnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work" , true, false , false , null);
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", "work", null, (i + "hello work queue").getBytes());
        }

        RabbitmqUtils.closeConnectionAndChanel(channel, connection);
    }
}
