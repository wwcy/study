package com.wcy;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M -XX:+HeapDumpOnOutOfMemoryError
 * @auth wcy on 2019/8/26.
 */
public class RuntimeConstantPoolOOM {

    public static class Programmer{
        public void code()
        {
            System.out.println("I'm a Programmer,Just Coding.....");
        }
    }

    public static void main(String[] args) {
       /* List<String> list = new ArrayList<>();

        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }*/
        for (int i = 0; i < 100000; i++) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Programmer.class);
            enhancer.setCallbackTypes(new Class[]{Dispatcher.class,MethodInterceptor.class});
            enhancer.setCallbackFilter(new CallbackFilter() {
                @Override
                public int accept(Method method) {
                    return 1;
                }
            });
            Class c = enhancer.createClass();
            System.out.println(i);
        }
        
    }
}
