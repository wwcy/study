package com.wcy;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @auth wcy on 2019/8/28.
 */
public class Allocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
       testAllocation();
      // Thread.sleep(5000);
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[6 * _1MB];  // 出现一次Minor GC
    }
}
