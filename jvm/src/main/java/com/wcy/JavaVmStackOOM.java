package com.wcy;

/**
 * -Xss20M
 * @auth wcy on 2019/8/26.
 */
public class JavaVmStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            new Thread(()->{
               dontStop();
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }

}
