package com.wcy.classload;

/**
 * @auth wcy on 2019/9/3.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        {
            byte[] b = new byte[64 * 1024 * 1024];
        }
        int a;

       // System.out.println(a);
        System.gc();
    }

}
