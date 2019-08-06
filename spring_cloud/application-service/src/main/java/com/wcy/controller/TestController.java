package com.wcy.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wcy on 2019/6/4.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public Map<String,String> test() throws InterruptedException {
        Map<String,String> map = new HashMap<>();
        map.put("success","aaa");
        return map;
    }

    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file")MultipartFile file){
        return file.getName();
    }
}
