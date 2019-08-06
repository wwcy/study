package com.wcy.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by wcy on 2019/6/20.
 */
@FeignClient("application-service")
public interface TestClient {

    @GetMapping("/test")
    Map<String,String> consumer();
}
