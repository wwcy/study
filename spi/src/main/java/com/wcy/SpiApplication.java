package com.wcy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SpiApplication {

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		SpringApplication.run(SpiApplication.class, args);
	}

}
