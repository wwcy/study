package com.wcy;

import com.netflix.discovery.shared.transport.decorator.RetryableEurekaHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScanBeanDefinitionParser;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSingleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerSingleApplication.class, args);
	}

}
