package com.lin.stream.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(StreamHelloApplicationTests.SinkSender.class)
public class StreamHelloApplicationTests {
    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void senderTest() {
        sinkSender.output().send(MessageBuilder.withPayload("product a message : hello").build());
    }

    public interface SinkSender{
        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();
    }
}
