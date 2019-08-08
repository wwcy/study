package cas;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Main {

    //static Thread t;

    private static Object lockObject = new Object();

    public static void main(String[] args) {
       /* waitThread();
        notifyThread();*/
      Thread a = new Thread(()->{
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("aaaa");
       });
      a.setDaemon(true);

       Thread b = new Thread(()->{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaaa111");
        });
       b.setDaemon(true);

        System.out.println(Thread.currentThread().getName());
    }

    private static void waitThread(){
          new Thread(()->{
             //LockSupport.unpark(t);
              //synchronized (lockObject){
                System.out.println(Thread.currentThread().getName() + "==wait-before");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    //lockObject.wait();
                    //LockSupport.park(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "==after-wait");
           // }
        },"wait").start();
        //t.start();
    }

    private static void notifyThread(){
        new Thread(()->{
           // synchronized (lockObject){
                System.out.println(Thread.currentThread().getName() + "==notify-before");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    //lockObject.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "==after-notify");
          // }
        },"notify").start();
    }

}
