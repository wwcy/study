package com.example.service;

/**
 * @auth wcy on 2019/9/27.
 */
public interface UserService {

    void register(String name, String password);

    String login(String name, String password);

}
