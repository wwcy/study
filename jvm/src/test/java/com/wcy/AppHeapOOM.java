package com.wcy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Comparator;

/**
 * Unit test for simple App.
 */
public class AppHeapOOM
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {
        System.out.println(f(2));
    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
                return value;
        }
}

    private static <T extends Number & Comparable<? super T>> T min(T[] values){
        return values[0];
    }
}
