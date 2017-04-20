package com.khh.part2;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/16.
 * 测试  收集结果
 */
public class TestCollect {

    public static Integer[] ORDERS = {1,2,3,4};

    public static String[] STRS = {"hello","groovy","java","JRuby"};

    /**
     * 收集结果并返回为数组
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        List<String> strList = Arrays.asList(STRS);
        Stream<String> stream = strList.stream().map(w -> w.toUpperCase());
        String[] strings = stream.toArray(String[]::new);
        System.out.println(strList);
        System.out.println(Arrays.asList(strings));
        //输出结果：
        //[hello, groovy, java, JRuby]
        //[HELLO, GROOVY, JAVA, JRUBY]
    }

    /**
     * 收集结果并返回HashSet
     */
    @Test
    public void test2() throws Exception{
        List<String> strList = Arrays.asList(STRS);
        Stream<String> stream = strList.stream().map(w -> w.toUpperCase());
        // 1
//        HashSet<String> collect = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
//        System.out.println(collect); //  [JAVA, HELLO, JRUBY, GROOVY]

        //2
//        Set<String> collect1 = stream.collect(Collectors.toSet());
//        System.out.println(collect1); //  [JAVA, HELLO, JRUBY, GROOVY]

        //3
        TreeSet<String> collect2 = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect2); //  [GROOVY, HELLO, JAVA, JRUBY]
    }

    /**
     * 收集结果并返回List
     */
    @Test
    public void test3() throws Exception{
        List<String> strList = Arrays.asList(STRS);
        Stream<String> stream = strList.stream().map(w -> w.toUpperCase());
        List<String> collect = stream.collect(Collectors.toList());
        System.out.println(collect); //[HELLO, GROOVY, JAVA, JRUBY]
    }

    /**
     * 收集结果并返回String
     */
    @Test
    public void test4() throws Exception{
        List<String> strList = Arrays.asList(STRS);
        Stream<String> stream = strList.stream().map(w -> w.toUpperCase());

//        String collect = stream.collect(Collectors.joining());
//        System.out.println(collect);//HELLOGROOVYJAVAJRUBY

        String collect2 = stream.collect(Collectors.joining(","));
        System.out.println(collect2);//HELLO,GROOVY,JAVA,JRUBY
    }

    /**
     * 收集结果返回一个   总和，平均值，最大值，最小值
     */
    @Test
    public void test5() throws Exception{
        List<String> strList = Arrays.asList(STRS);
        Stream<String> stream = strList.stream().map(w -> w.toUpperCase());

        IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(String::length));
        //返回总和
        long sum = summary.getSum();
        //返回最大值
        long max = summary.getMax();
        System.out.println(sum); //20
        System.out.println(max);  //6
    }

    /**
     * 收集结果返回一个 map(有时候键会重复，避免此情况，用了(existingValue, newValue) -> existingValue解决)
     * @throws Exception
     */
    @Test
    public void test6() throws Exception{
        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());

        Map<String, String> collect = locals.collect(Collectors.toMap(
                l -> l.getDisplayLanguage(),
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue
        ));
        for (Map.Entry<String, String> entries : collect.entrySet() ){
            System.out.println(entries.getKey() + ":" + entries.getValue());
        }
    }

    /**
     * 收集结果返回一个 map(收集成一个map，键为国家，值为该国家的语言集合)
     * @throws Exception
     */
    @Test
    public void test7() throws Exception{
        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());

        Map<String, Set<String>> collect = locals.collect(Collectors.toMap(
                l -> l.getDisplayCountry(),
                l -> Collections.singleton(l.getDisplayLanguage()),
                (a ,b ) -> {
                    Set<String> r = new HashSet<String>(a);
                    r.addAll(b);
                    return r;
                }
        ));
        for (Map.Entry<String, Set<String>> entries : collect.entrySet() ){
            System.out.println(entries.getKey());
            Set<String> strs = entries.getValue();
            strs.forEach(System.out::println);
            System.out.println("--------------");
        }
    }
}
