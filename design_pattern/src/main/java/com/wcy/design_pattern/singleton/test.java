package com.wcy.design_pattern.singleton;

import java.lang.reflect.Constructor;

public class test {

    public static void main(String[] args) throws Exception{
        /*for (int i = 0; i < 200; i++) {
           Thread t = new Thread(()->{

                Singleton singleton = Singleton.getInstance();
                System.out.println(Thread.currentThread().getName()+"=="+singleton);
            });
            t.setName(String.valueOf(i));
            t.start();

        }*/
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        Class c = Class.forName("com.wcy.design_pattern.singleton.Singleton");
        Constructor constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton s = (Singleton)constructor.newInstance();
        System.out.println(s);

    }
}
