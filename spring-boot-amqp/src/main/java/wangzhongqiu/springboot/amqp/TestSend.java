package wangzhongqiu.springboot.amqp;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class TestSend {
    private final static String QUEUE_NAME = "testdurable";
    private final static String QUEUE_IP = "你的服务器IP或域名";
    private final static int QUEUE_PORT = 5672;//RabbitMQ对外服务端口
    private final static String QUEUE_USER = "testuser";
    private final static String QUEUE_PWD = "123456";

    @Autowired
    private Environment env;

    public static void main(String[] argv) throws java.io.IOException, TimeoutException {
        /**
         * 创建连接连接到MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名
        factory.setHost(QUEUE_IP);
        factory.setPort(QUEUE_PORT);// MQ端口
        factory.setUsername(QUEUE_USER);// MQ用户名
        factory.setPassword(QUEUE_PWD);// MQ密码
        //创建一个连接
        Connection connection = factory.newConnection();
        //创建一个频道
        Channel channel = connection.createChannel();
        //指定一个队列
        //channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //如QUEUE_NAME是一个transient的queue，第二个参数必须是false；重启rabbit后QUEUE_NAME会被删除掉
        //如QUEUE_NAME是一个durability的queue，第二个参数必须是true；重启rabbit后QUEUE_NAME不会被删除掉
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        //发送的消息
        String message = "hello world!";
        //往队列中发出一条消息
        int j = 0;
        Long start = System.currentTimeMillis();
        for (int i = j; i < j + 10000; i++) {
            //将消息保存起来，重启rabbit后待消费的消息不会被删除
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, (message + i).getBytes());

            //不保存消息，重启rabbit后待消费的消息都将丢失
            //channel.basicPublish("", QUEUE_NAME, null, (message+i).getBytes());
        }
        System.out.println("发送完成：" + (System.currentTimeMillis() - start));
        //关闭频道和连接
        channel.close();
        connection.close();
    }
}