package com.example.hystrix.service;

import com.example.hystrix.utils.HttpClient;
import org.springframework.stereotype.Service;
import sun.net.NetworkServer;

import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.*;

@Service
public class TestService {

    private static String url = "http://localhost:10001/user/get";


    public TestService(){
        System.out.println("构造----");
    }

    static class Work<T>{
        public CompletableFuture<String> future = null;
        public String id;
    }


    public static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private static BlockingQueue<Work> queue = new LinkedBlockingQueue<>();

   /* static {
        System.out.println("静态块----");
        executorService.scheduleAtFixedRate(()->{

            List<Work> list = new ArrayList<>();
            Set<String> set = new HashSet<>();

            while (true){
                Work work1 = queue.poll();
                if(work1 == null){
                    break;
                }
                list.add(work1);
                set.add(work1.id);
            }

            Iterator<Work> iterable = list.iterator();

            for (String  id1 : set) {
                String request = HttpClient.getRequest(url,id1);

                while (iterable.hasNext()){
                    Work work1 = iterable.next();
                    if(work1.id.equals(id1)){
                        work1.future.complete(request);
                        //iterable.remove();
                    }
                }
            }

        }, 0, 500, TimeUnit.MILLISECONDS);
    }*/

    /**
     *用于高并发查询 请求合并
     * @return
     */
    public void test(String id,CountDownLatch count){
        long start = System.currentTimeMillis();

       /* CompletableFuture<String> future = new CompletableFuture<>();

        Work<String> work = new Work<>();
        work.future = future;
        work.id = id;
        queue.add(work);
        try {

            String result = future.get();
            System.out.println(Thread.currentThread().getName()+"   "+(System.currentTimeMillis() - start) + " 毫秒");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            count.countDown();
        }*/
        String request = HttpClient.getRequest(url,id);
        count.countDown();

        //return request;
    }
}
