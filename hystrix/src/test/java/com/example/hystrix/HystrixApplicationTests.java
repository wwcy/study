package com.example.hystrix;

import com.example.hystrix.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HystrixApplicationTests {

	@Autowired
	private TestService testService;

	@Test
	public void contextLoads() throws Exception{

		CountDownLatch count = new CountDownLatch(100);

		for (int i = 0; i < 100;i++) {

			if(i % 3 == 0){
				new Thread(()-> testService.test("12e9e0fdb76b4319b3af65ebcf34fd83",count)).start();

			}else if(i % 3 == 1) {
				new Thread(()-> testService.test("b453afaeb0b845a3b4cd28119d6a9772",count)).start();
			}else if(i % 3 == 2) {
				new Thread(()-> testService.test("d7ee82b86f1e4419bde61fdba69d3a4d",count)).start();
			}

		}
		count.await();
		TestService.executorService.shutdown();
		//String result = testService.test("12e9e0fdb76b4319b3af65ebcf34fd83");
		//System.out.println(result);

	}

}
