package cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @auth wcy on 2019/10/24.
 */
public class SemaphoreDemo {

    private static final int threadCount = 550;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(300);
        Semaphore semaphore = new Semaphore(20,true);

        for (int i = 0; i < threadCount; i++) {
            final int num = i;
            pool.execute(()->{
                try {
                    semaphore.acquire();
                    test(num);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+":"+threadNum);
    }
}
