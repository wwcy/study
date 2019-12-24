package com.wcy.aop;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auth wcy on 2019/10/29.
 */
public class PorxyDemoServices implements FactoryBean<Object> {

    private String interfaceName;
    private Object target;
    private volatile Object proxyTarget;

    @Override
    public Object getObject() throws Exception {
        if(proxyTarget == null){
            synchronized (this){
                if (proxyTarget == null) {
                    proxyTarget = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Class.forName(interfaceName)},
                            (Object proxy, Method method, Object[] args) -> {
                                System.out.println("invoke method......" + method.getName());
                                return method.invoke(target, args);
                            });
                }
            }
        }
         return proxyTarget;
    }

    @Override
    public Class<?> getObjectType() {
        return proxyTarget == null ? Object.class : proxyTarget.getClass();
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
