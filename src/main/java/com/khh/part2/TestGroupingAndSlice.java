package com.khh.part2;

import org.junit.Test;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/20.
 * 测试分组和分片
 */
public class TestGroupingAndSlice {

    /**
     * testing groupingBy（根据xxxx分组）
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> collect = locals.collect(Collectors.groupingBy(Locale::getCountry));
        List<Locale> ch = collect.get("CH");
        ch.forEach(System.out::println);
    }


    /**
     * 当分类函数是一个predicate函数(即返回一个布尔值的函数)时，可以用partitioningBy,比groupingBy更有效率
     * testing 可以用partitioningBy（根据xxxx分组）
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> map = locals.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        map.get(true).forEach(System.out::println);
    }

    /**
     * counting收集器(返回收集元素的总个数)
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> map = locals.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
        for (Map.Entry<String, Long> entries : map.entrySet() ){
            System.out.println(entries.getKey() + ":" + entries.getValue());
        }
    }


}
