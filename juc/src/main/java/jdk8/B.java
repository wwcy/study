package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @auth wcy on 2019/10/28.
 */
public class B {

    public static void main(String[] args) {

       /* Converter<String,Integer> converter = Integer::valueOf;
        Integer i = converter.convert("123");
        System.out.println(i);

        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("123"));

        Predicate<String> predicate1 = String::isEmpty;
        System.out.println(predicate1.test("123"));*/

        List<String> a = Arrays.asList("a","b","c","d","a");


    }
}
