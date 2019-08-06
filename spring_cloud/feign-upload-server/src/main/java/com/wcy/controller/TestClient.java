package com.wcy.controller;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by wcy on 2019/6/20.
 */
@FeignClient(value = "application-service",configuration = TestClient.MultipartSupportConfig.class)
public interface TestClient {

    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file")MultipartFile file);

    @Configuration
    class MultipartSupportConfig{
        @Bean
        public Encoder feignFormEncoder(){
            return new SpringFormEncoder();
        }
    }
}
