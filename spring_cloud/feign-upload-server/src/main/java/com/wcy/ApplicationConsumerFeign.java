package com.wcy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationConsumerFeign {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConsumerFeign.class, args);
	}

}
