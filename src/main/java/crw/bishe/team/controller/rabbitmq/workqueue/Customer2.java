package crw.bishe.team.controller.rabbitmq.workqueue;

import com.rabbitmq.client.*;
import crw.bishe.team.utils.RabbitmqUtils;

import java.io.IOException;

public class Customer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getconnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work", true, false , false, null);
        channel.basicConsume("work", true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("消费者 - 2 ： " + new String(body));
            }
        });
    }
}
