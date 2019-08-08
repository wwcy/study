package cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wcy on 2019/6/13.
 */
public class AtomicIntegerTest {

    private static final Unsafe unsafe = getUnsafe();

    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (AtomicIntegerTest.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private volatile int value = 0;

    volatile Integer[] integer = new Integer[]{0};

    public static void main(String[] args) throws Exception{
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        atomicIntegerTest.integerTest();
       //AtomicIntegerTest();
    }

    private void integerTest() throws InterruptedException {

        for (int i = 0;i<10;i++){
            Thread thread = new Thread(()->{
                System.out.println("线程名称==="+Thread.currentThread().getName());
               for (int j = 0;j<1000;j++){
                    unsafe.getAndAddInt(this,valueOffset,1);
               }
              // System.out.println(value);
            });
            thread.start();
        }
       while (Thread.activeCount() > 2) {
            Thread.sleep(10);
        }
       // System.out.println(Thread.currentThread().getName()+"======"+value);
    }

    private static void AtomicIntegerTest() throws InterruptedException {
         AtomicInteger casi = new AtomicInteger();
        casi.set(0);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                    for (int j = 0; j < 1000; j++) {
                        casi.getAndIncrement();
                    }
            });
            thread.start();
        }
        while (Thread.activeCount() > 2) {
            Thread.sleep(10);
        }
        System.out.println(casi.get());
    }


    private static Unsafe getUnsafe() {
        Class<?> unsafeClass = Unsafe.class;

        for (Field f : unsafeClass.getDeclaredFields()) {
            if ("theUnsafe".equals(f.getName())) {
                f.setAccessible(true);
                try {
                    return (Unsafe) f.get(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
      //  throw new IllegalAccessException("no declared field: theUnsafe");
    }
}
