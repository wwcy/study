package com.wcy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @auth wcy on 2019/10/31.
 */
@Aspect
@Component
public class LogAspect {

    @Before("@annotation(com.wcy.aop.Log)")
    public void log(){
        System.out.println("方法开始。。。。。");
    }
}
