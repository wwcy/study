package com.wcy;

import com.wcy.aop.DemoServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        DemoServices porxyDemoServices = (DemoServices)context.getBean("porxyDemoServices");
        Object porxyDemoServices1 = context.getBean("&porxyDemoServices");
        porxyDemoServices.fun();
        System.out.println(porxyDemoServices1.getClass());
    }
}
