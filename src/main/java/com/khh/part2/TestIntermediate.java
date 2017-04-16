package com.khh.part2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/16.
 * 测试 Strean的中间操作
 */
public class TestIntermediate {

    public static int[] orders = {1,2,3,4};

    public static String[] STRS = {"hello","groovy","java","JRuby"};

    /**
     * filter
     * filter方法的参数是一个Predicate<T>对象----即一个从T到boolean的函数
     */
    @Test
    public void test1() throws Exception{
        List<String> list = Arrays.asList(STRS);
        //此流 包含了 所有长度大于4的字符串元素
        Stream<String> stream = list.stream().filter(str -> str.length() > 4);
        stream.forEach(System.out::print);
        //输出  ：  hellogroovyJRuby
    }

    /**
     * map
     * map的参数是一个方法表达式 或者 方法引用
     * 当使用map方法时，会对每个元素应用一个函数，并将返回的值收集到一个新的流中
     */
    @Test
    public void test2() throws Exception{
        List<String> list = Arrays.asList(STRS);
        //把所有单词转换成大写
        Stream<String> stream = list.stream().map(s -> s.toUpperCase());
        stream.forEach(System.out::print);
        //输出 ：HELLOGROOVYJAVAJRUBY
    }

    /**
     * flatMap
     */
    public static Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for(char c: s.toCharArray()){
            result.add(c);
        }
        return result.stream();
    }
    @Test
    public void test3() throws Exception{
        List<String> list = Arrays.asList(STRS);

        Stream<Stream<Character>> streamStream = list.stream().map(m -> characterStream(m));
        streamStream.forEach(System.out::println);

        Stream<Character> characterStream = list.stream().flatMap(m -> characterStream(m));
        characterStream.forEach(System.out::print);
    }

}
