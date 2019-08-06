package com.wcy.spi.jdkspi.impl;

import com.wcy.spi.jdkspi.Service;

/**
 * @auth wcy on 2019/8/5.
 */
public class BlueServiceImpl implements Service{


    @Override
    public void sayHello() {
        System.out.println("BlueServiceImpl");
    }
}
