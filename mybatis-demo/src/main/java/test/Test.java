package test;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
	
		Predicate<String> p0 = (n)-> n.startsWith("j");
		Predicate<String> p1 = (n)-> n.length() == 4;
		
		List<String> lan = Arrays.asList("java","Scala","Lisp");
		
		lan.stream().filter(p0.and(p1))
		.forEach(System.out::println);
	/*	ProxyTest proxyTest = new ProxyTest(new TestRel());
		TestInterface testInterface = (TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(),new Class[]{TestInterface.class},proxyTest);
		List list = testInterface.main();
		System.out.println(list);*/
	}

}
