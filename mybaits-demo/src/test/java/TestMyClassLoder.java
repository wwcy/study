import mybaits.mybaitsTest;
import net.sf.cglib.proxy.*;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import org.apache.ibatis.plugin.Interceptor;
import test.TestInterface;
import test.TestRel;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcy on 2019/3/14.
 */
public class TestMyClassLoder {

    public static class Programmer{
        public void code()
        {
            System.out.println("I'm a Programmer,Just Coding.....");
        }
    }

  /*  public static class Hacker implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args,
                                MethodProxy proxy) throws Throwable {
            System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
            proxy.invokeSuper(obj, args);
            System.out.println("****  Oh,what a poor programmer.....");
            return null;
        }

    }*/

    public static class Hacker implements InvocationHandler {

        private TestRel testRel;

        public  Hacker(TestRel testRel){
            this.testRel = testRel;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
            testRel.main();
            System.out.println("****  Oh,what a poor programmer.....");
            return null;
        }
    }


    public static void main(String[] args) throws Exception{
        Hacker hacker = new Hacker(new TestRel());
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Programmer.class);
        //enhancer.setInterfaces(new Class[]{TestInterface.class});
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer)enhancer.create();
        proxy.code();

      /*  TestInterface t = (TestInterface)Proxy.newProxyInstance(TestInterface.class.getClassLoader(),new Class[]{TestInterface.class},hacker);
        t.main();
        mybaitsTest.generateClassFile(t.getClass(),"TestInterfaceProxy1");*/
       /* MyClassLoder myClassLoder = new MyClassLoder("C:\\Demo");
        try {
            Class c = myClassLoder.findClass("Demo");
            if(c != null){
                Object object = c.newInstance();
                Method method = c.getMethod("say",null);
                method.invoke(object,null);
                System.out.println(c.getClassLoader().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
       /* TestMyClassLoder testMyClassLoder = new TestMyClassLoder();

        TestMyClassLoder o = (TestMyClassLoder)testMyClassLoder.invoke();
        System.out.println(o);*/


    }

    public Object invoke() throws Exception{
        Class c = TestMyClassLoder.class;
        Object o = c.newInstance();
        Method method = c.getMethod("say",null);
        return method.invoke(o,null);
    }

    public void say(){
        System.out.println("ssss");
    }
}
