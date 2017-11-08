package wangzhongqiu.springboot.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTests {

	@MockBean
	private Runner runner;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Receiver receiver;

	@Test
	public void test() throws Exception {
		rabbitTemplate.convertAndSend(SpringBootAmqpApplication.queueName, "Hello from RabbitMQ!");
	}

}
