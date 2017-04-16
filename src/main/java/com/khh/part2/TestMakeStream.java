package com.khh.part2;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/16.
 * 测试   创建Stream的API
 */
public class TestMakeStream {

    public static int[] orders = {1,2,3,4};

    public static String[] STRS = {"hello","groovy","java","JRuby"};

    /**
     * List转Stream
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        List<String> list = Arrays.asList(STRS);

        /**
         * 用stream()方法
         *  串行执行
         */
        Stream<String> stream = list.stream().filter(str -> str.length() > 4);

        /**
         * 用parallelStream方法
         * 并行执行
         */
        Stream<String> strStream = list.parallelStream().filter(str -> str.length() > 4);
        //区别如下
        list.stream().filter(str -> str.length() > 4).forEach(System.out::print);
        //输出  ：  hellogroovyJRuby
        System.out.println();
        list.parallelStream().filter(str -> str.length() > 4).forEach(System.out::print);
        //输出  ：JRubygroovyhello
        System.out.println();
    }

    /**
     * 数组 转Stream
     */
    @Test
    public void test2() throws Exception{
        // 1
        Stream<String> strs = Stream.of(STRS);

        //2
        int from = 1;
        int to = 3;
        //将数组一部分转换成为stream
        Stream<String> stream = Arrays.stream(STRS, from, to);
//        System.out.println("stream.cout = " + stream.count());  // 输出结果: stream.cout = 2
        stream.forEach(System.out::println);
        //输出：groovy
        //       java
        /**
         * 注意：一个流只能有一个末端操作，当一个流调用完末端操作之后，流就会被用完，count()和forEach()都是末端操作
         */
    }

    /**
     * 创建一个不含元素的Stream
     */
    @Test
    public void test3() throws Exception{
        //泛型<String> 会被编译器推到出来,这同Stream.<String>empty()一样
        Stream<String> empty = Stream.empty();
    }

    /**
     * 创建无限Stream的静态方法
     */
    @Test
    public void test4() throws Exception{
        //1.Stream的generate方法接受一个无参数的函数(或者从技术上说，是一个Supplier<T>接口的对象)
        Stream<String> echos = Stream.generate(() -> "Echo");

        //2.创建一个形如0 1 2 3 4.....的无限序列，可以使用iterate方法
        //它接受一个"种子（seed）"和一个函数(从技术上讲，是一个UnaryOpertor<T>接口的对象)
        Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        //序列中的第一个元素是种子BigInteger.ZERO,第二个值是f(seed),或者1(一个大整数);下一个元素是f(f(seed))，或者2
        //以此类推
    }
}
