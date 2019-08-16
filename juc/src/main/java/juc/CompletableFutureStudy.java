package juc;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @auth wcy on 2019/8/7.
 */
public class CompletableFutureStudy {

    @Test
    public void thenApply() throws Exception{
        CompletableFuture result = CompletableFuture.supplyAsync(
                () -> "hello"
        ).thenApply(s -> s+" world")
        .whenComplete((r,e)->{

        });
        System.out.println(result.get());
    }

    @Test
    public void runAsync() throws Exception{
        final CompletableFuture future = CompletableFuture.runAsync(()->{
            /*try{
               // TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){

            }*/
            System.out.println("run end ...");
        });
        future.complete("ssss");
        System.out.println(future.get());
    }

    @Test
    public void whenComplete() throws Exception{
        CompletableFuture future = CompletableFuture.supplyAsync(
                ()->{
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                    }
                   /* if(new Random().nextInt()%2 >= 0){
                        int i = 12/0;
                    }*/
                    //System.out.println("run end ...");
                    return "返回";
                }
        );

        future.whenComplete((r, e) ->
            System.out.println("执行完成")
        );

        future.exceptionally((o) -> {
            System.out.println("执行失败：："+((Throwable)o).getMessage());
            return null;
        });

        System.out.println(future.get());
        //TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void handle(){
        CompletableFuture.supplyAsync(()->
           "hello "
        ).thenApplyAsync((r)-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //int i = new Random().nextInt()/0;
                    return r + "word";
                }
        ).handle((r,e)->{
            String result = null;
            if(e == null){
                result = r;
            }else {
                System.out.println(e.getMessage());
            }
            return result;
        }).whenCompleteAsync((r,e)->{
            System.out.println(r);
        });

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thenAccept() throws Exception{
        CompletableFuture future = CompletableFuture.supplyAsync(()->{
            return new Random().nextInt(10);
        }).thenAccept(integer -> {
            System.out.println(integer);
        });
        System.out.println(future.get());

    }

    @Test
    public void thenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture future = CompletableFuture.supplyAsync(()->"hello ");
        CompletableFuture future1 = CompletableFuture.supplyAsync(()->"word");
        CompletableFuture result = future.thenCombine(future1,(t,u)->{
            return  (String)t+u;
        });
        System.out.println(result.get());
    }

    @Test
    public void thenAccepBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(()->{
            int t = 3;
            try {
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("f1="+t);
            return t;
        });

       CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(()->{
            int t = 3;
            try {
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("f2="+t);
            return t;
        });

       f1.thenAcceptBoth(f2, (integer, integer2) -> System.out.println("f3="+integer+integer2));

       f1.get();
    }

    @Test
    public void thenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture f1 = CompletableFuture.supplyAsync(()->{
            return 6;
        }).thenCompose((p)->
           CompletableFuture.supplyAsync(()->p+4)
        );
        System.out.println(f1.get());
    }
}
