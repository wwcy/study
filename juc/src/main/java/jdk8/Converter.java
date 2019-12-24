package jdk8;

/**
 * @auth wcy on 2019/10/28.
 */
@FunctionalInterface
public interface Converter<F,T> {
    
    T convert(F form);
}
