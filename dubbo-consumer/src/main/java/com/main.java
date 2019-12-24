package com;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.example.service.UserService;
import com.example.service.impi.UserServiceComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @auth wcy on 2019/9/29.
 */
public class main {

    public static void main(String[] args) throws IOException {
      /*  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        UserService userService = (UserService)context.getBean("userService");
        userService.login("wcy","123");*/
     /*   ReferenceConfig<UserService> config = new ReferenceConfig<>();
        config.setApplication(new ApplicationConfig("dubbo-consumer"));
        config.setRegistry(new RegistryConfig("zookeeper://192.168.245.129:2181"));
        config.setInterface(UserService.class);
        UserService userService = config.get();
        userService.login("wcy","123");*/
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
     context.start();
     UserServiceComponent userService = (UserServiceComponent) context.getBean("userServiceComponent");
     userService.login("wcy","123");
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.example.service.impi")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = "com.example.service.impi")
    static class ConsumerConfiguration{

    }
}
