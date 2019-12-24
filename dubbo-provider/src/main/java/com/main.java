package com;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.example.impl.UserServiceImpl;
import com.example.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @auth wcy on 2019/9/29.
 */
public class main {

    public static void main(String[] args) throws IOException {
      /*  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();
        System.in.read();*/
        /*ServiceConfig<UserService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://192.168.245.129:2181"));
        service.setInterface(UserService.class);
        service.setRef(new UserServiceImpl());
        service.export();*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.example.impl")
    @PropertySource("classpath:/spring/dubbo-provider.properties")
    static class ProviderConfiguration{


        /*@Bean
        public RegistryConfig registryConfig(){
            RegistryConfig config = new RegistryConfig();
            config.setAddress("zookeeper://192.168.245.129:2181");
            return config;
        }*/
    }
}
