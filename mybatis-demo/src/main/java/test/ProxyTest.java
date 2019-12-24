package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcy on 2019/3/18.
 */
public class ProxyTest implements InvocationHandler {

    private TestRel testRel;

    public ProxyTest(TestRel testRel){
        this.testRel = testRel;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         return result();
    }

    public List result(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        return  list;
    }

}
