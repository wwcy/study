package com.wcy.cinit;

/**
 * @auth wcy on 2019/9/3.
 */

public class Test1 {

    static class DeadLoopClass {

        static {

            if (true) {
                System.out.println(Thread.currentThread() + " init");

                while (true) {

                }
            }

        }
    }

    public static void main(String[] args) {
        Runnable r = ()-> {
            System.out.println(Thread.currentThread()+" start");
            DeadLoopClass dlc= new DeadLoopClass();
            System.out.println(Thread.currentThread()+" over");
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}