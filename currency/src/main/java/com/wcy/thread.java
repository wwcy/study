package com.wcy;

/**
 * @auth wcy on 2019/12/30.
 */
public class thread implements Runnable{


    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new thread()).start();
        }
    }
}
