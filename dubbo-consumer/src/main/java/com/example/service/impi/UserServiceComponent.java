package com.example.service.impi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @auth wcy on 2019/9/30.
 */
@Component
public class UserServiceComponent implements UserService {

    @Reference
    private UserService userService;


    @Override
    public void register(String name, String password) {

    }

    @Override
    public String login(String name, String password) {
        return userService.login(name,password);
    }
}
