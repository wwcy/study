package com.wcy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wcy on 2019/6/4.
 */
@RestController
public class Testcontroller {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test")
    @HystrixCommand(defaultFallback = "fallback")
    public Map<String,String> test(){

        return restTemplate.getForObject("http://application-service/test",Map.class);
    }

    public Map<String,String> fallback(){
        Map<String,String> map = new HashMap();
        map.put("fallback","true");
        return map;
    }
}
