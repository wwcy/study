package com.wcy.design_pattern.factory;

import com.wcy.design_pattern.factory.entity.Milk;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Milk milk = factory.getMileName("yili");
        System.out.println(milk);
    }
}
