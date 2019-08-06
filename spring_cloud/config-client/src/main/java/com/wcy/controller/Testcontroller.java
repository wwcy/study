package com.wcy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wcy on 2019/6/4.
 */
@RefreshScope
@RestController
public class Testcontroller {

    @Value("${test}")
    private String test;

    @RequestMapping("/test")
    public String test(){
        return this.test;
    }
}
