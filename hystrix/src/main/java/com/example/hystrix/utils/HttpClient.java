package com.example.hystrix.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {

    public static volatile int index;

    public static String getRequest(String url,String parameter){
        System.out.println(++index +"  发起请求----    "+ parameter);
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

            HttpGet httpGet = new HttpGet(url + "?" + "id=" + parameter);

            try(CloseableHttpResponse response = httpClient.execute(httpGet)){
                // 从b响应模型中获取响应实体
                HttpEntity responseEntity = response.getEntity();
                return EntityUtils.toString(responseEntity);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
