package com.wcy;

/**
 * @auth wcy on 2019/8/26.
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    public static void main(String[] args) throws Exception{
        ReferenceCountingGC.testGC();
       // Thread.sleep(10000);
    }
}
