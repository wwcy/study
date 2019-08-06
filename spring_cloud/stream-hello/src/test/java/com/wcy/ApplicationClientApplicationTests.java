package com.wcy;

import com.wcy.controller.Testcontroller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@EnableBinding(ApplicationClientApplicationTests.SinkSender.class)
public class ApplicationClientApplicationTests {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void sinkSenderTest(){
        sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
    }

    public interface SinkSender{
        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();
    }

}
