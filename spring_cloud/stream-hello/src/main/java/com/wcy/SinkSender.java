package com.wcy;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wcy on 2019/6/24.
 */
//@EnableBinding(Source.class)
public class SinkSender {

   /* private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>("{\"name\":\"didi\", \"age\":30}" + atomicInteger.incrementAndGet());
    }*/
}
