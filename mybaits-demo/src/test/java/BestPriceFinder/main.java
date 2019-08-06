package BestPriceFinder;

import java.util.concurrent.Executors;

/**
 * Created by wcy on 2019/6/10.
 */
public class main {

    public static void main(String[] args) {
        main main = new main();
       // main.findPrices();
        main.findPricesAsync();
       // main.findPricesParallel();
    }

    public void findPrices(){
        BestFinder bestFinder = new BestFinder();
        long st = System.currentTimeMillis();
        System.out.println(bestFinder.findPrices("iPhonX"));
        System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
    }

    public void findPricesParallel(){
        BestFinder bestFinder = new BestFinder();
        long st = System.currentTimeMillis();
        System.out.println(bestFinder.findPrices("iPhonX"));
        System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
    }

    public void findPricesAsync(){
        BestFinder bestFinder = new BestFinder();
        long st = System.currentTimeMillis();
        System.out.println(bestFinder.findPricesAsync("iPhonX"));
        System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
    }
}
