package cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @auth wcy on 2019/10/24.
 */
public class AtomicStampedReferenceDemo {

    public static void main(String[] args) {
        Integer initialRef = 0,initialStamp = 0;
        new AtomicStampedReference<>(initialRef,initialStamp);
    }
}
