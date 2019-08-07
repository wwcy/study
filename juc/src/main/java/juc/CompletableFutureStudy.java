package juc;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @auth wcy on 2019/8/7.
 */
public class CompletableFutureStudy {

    @Test
    public void thenApply(){
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s+" world").join();
        System.out.println(result);
    }
}
