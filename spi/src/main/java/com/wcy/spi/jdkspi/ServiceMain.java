package com.wcy.spi.jdkspi;

import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @auth wcy on 2019/8/5.
 */
public class ServiceMain {

    public static void main(String[] args) {
        ServiceLoader<Service> loader = ServiceLoader.load(Service.class);
        Iterator<Service> iterator = loader.iterator();
        while (iterator.hasNext()){
            Service service = iterator.next();
            service.sayHello();
        }
    }
}
