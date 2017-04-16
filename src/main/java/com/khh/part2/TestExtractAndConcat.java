package com.khh.part2;

import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/16.
 * 测试 提取子流 和 组合流
 */
public class TestExtractAndConcat {

    public static Integer[] ORDERS = {1,2,3,4};

    public static String[] STRS = {"hello","groovy","java","JRuby"};

    /**
     * limit(n)
     * 会返回一个包含n个元素的新流(如果原始流的长度小于n,则会返回原始的流)
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        //得到一个包含100个随机数的流
        Stream<Double> limit = Stream.generate(Math::random).limit(100);
        limit.forEach(System.out::print);
    }

    /**
     * skip(n)
     * 会返回一个丢弃了前n个元素的新流
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        Arrays.asList(STRS).stream().skip(1).forEach(System.out::print);
        //输出  :  groovyjavaJRuby
    }

    /**
     * concat(n)
     * 组合两个流
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        Stream<Integer> stream1 = Arrays.asList(ORDERS).stream();
        Stream<String> stream2 = Arrays.asList(STRS).stream();

        Stream<? extends Serializable> concat = Stream.concat(stream1, stream2);
        concat.forEach(System.out::print);
        //输出  ： 1234hellogroovyjavaJRuby

    }
}
