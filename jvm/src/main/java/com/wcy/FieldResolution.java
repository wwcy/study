package com.wcy;

/**
 * 字段解析
 * @auth wcy on 2019/9/3.
 */
public class FieldResolution {

    interface i0{
        int A = 0;
    }

    interface i1 extends i0{
        int A =1;
    }

    interface i2{
        int A = 2;
    }

    static class  Parent implements i1{
        public static int A = 3;
    }

    static class Sub extends Parent implements i2{
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
