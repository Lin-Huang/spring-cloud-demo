package com.lin.rabbitmq.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqHelloApplication.class)
public class RabbitmqHelloApplicationTests {
	@Autowired
	private Sender sender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void sendTest() {
		sender.send();
	}
}
