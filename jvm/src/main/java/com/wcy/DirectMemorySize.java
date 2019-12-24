package com.wcy;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M -XX:+HeapDumpOnOutOfMemoryError
 * @auth wcy on 2019/8/26.
 */
public class DirectMemorySize {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws Exception{
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
