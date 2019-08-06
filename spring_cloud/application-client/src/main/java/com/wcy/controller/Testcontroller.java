package com.wcy.controller;

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

import java.util.Map;

/**
 * Created by wcy on 2019/6/4.
 */
@RestController
public class Testcontroller {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/test")
    public Map<String,String> test(){

        ServiceInstance si = loadBalancerClient.choose("application-service");
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/test");

        RestTemplate rt = new RestTemplate();

        ParameterizedTypeReference<Map<String, String>> type = new ParameterizedTypeReference<Map<String, String>>() {};

        ResponseEntity<Map<String, String>> response = rt.exchange(sb.toString(), HttpMethod.GET, null, type);

        return response.getBody();
    }
}
