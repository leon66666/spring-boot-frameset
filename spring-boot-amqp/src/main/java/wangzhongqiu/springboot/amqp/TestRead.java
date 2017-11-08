package wangzhongqiu.springboot.amqp;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class TestRead
{
    private final static String QUEUE_NAME = "testdurable";
    private final static String QUEUE_IP = "你的服务器IP或域名";
    private final static int QUEUE_PORT = 5672;//RabbitMQ对外服务端口
    private final static String QUEUE_USER = "testuser";
    private final static String QUEUE_PWD = "123456";

    public static void main(String[] argv) throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException
    {
        //打开连接和创建频道，与发送端一样
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(QUEUE_IP);
        factory.setPort(QUEUE_PORT);// MQ端口
        factory.setUsername(QUEUE_USER);// MQ用户名
        factory.setPassword(QUEUE_PWD);// MQ密码
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("Waiting for messages. To exit press CTRL+C");

        //创建队列消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //指定消费队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
        Long start = System.currentTimeMillis();
        while (true)
        {
            //nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("Received '" + message + "'    "+(System.currentTimeMillis() - start));
        }
    }
}