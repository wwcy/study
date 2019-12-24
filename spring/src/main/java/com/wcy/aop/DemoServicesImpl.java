package com.wcy.aop;

/**
 * @auth wcy on 2019/10/29.
 */
public class DemoServicesImpl implements DemoServices{

    @Log
    public void fun(){
        System.out.println("fun------");
    }
}
