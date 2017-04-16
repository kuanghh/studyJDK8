package com.khh.part1;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created by 951087952@qq.com on 2017/4/14.
 * 测试  函数式接口
 */
public class TestFunctionalInterface {

    /**
     * Arrays.sort方法的第二个参数需要接收一个实现了Comparator<String>接口的类的实例
     * 这些对象和类的管理完全依赖与如何实现，因此比传统的内部类效率更高
     * 最好把一个lambda表达式想象成一个函数，而不是一个对象，它可以被转换成一个函数式接口
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        String[] words = {"hello","java","groovy"};
        Arrays.sort(words,(first,second) -> Integer.compare(first.length(),second.length()));
        System.out.println(Arrays.asList(words));
    }


    @Test
    public void test2() throws Exception{
        BiFunction<String,String,Integer> comp =
                (first,second) -> Integer.compare(first.length(),second.length());
        Integer i = comp.apply("hello", "java");
        System.out.println(i);
    }

    /**
     * 如果lambda表达式中可能会抛出一个检查期异常，那么该异常需要在目标接口的抽象方法中进行声明
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        Runnable zzz = () -> {
            System.out.println("Zzz");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(zzz).start();
    }
}
