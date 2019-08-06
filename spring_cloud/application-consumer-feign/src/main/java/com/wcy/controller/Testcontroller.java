package com.wcy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wcy on 2019/6/4.
 */
@RestController
public class Testcontroller {

    @Autowired
    TestClient testClient;

    @RequestMapping("/test")
    public Map<String,String> test(){
        return testClient.consumer();
    }
}
