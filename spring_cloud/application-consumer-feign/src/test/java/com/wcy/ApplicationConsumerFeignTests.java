package com.wcy;

import com.wcy.controller.Testcontroller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationConsumerFeignTests {

	@Autowired
	Testcontroller testcontroller;

	@Test
	public void contextLoads() {
		Map<String,String> map = testcontroller.test();
		map.forEach((k,v) -> {
			System.out.println(v);
		});
	}

}
