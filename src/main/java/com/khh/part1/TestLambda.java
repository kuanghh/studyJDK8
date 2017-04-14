package com.khh.part1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiConsumer;

/**
 * Created by 951087952@qq.com on 2017/4/14.
 * 测试lambda语法
 */
public class TestLambda {

    @Test
    public void test1() throws Exception{
        String first = "hello";
        String second = "java";
        int i = Integer.compare(first.length(),second.length());
        System.out.printf("i = " + i);
    }
    @Test
    public void test2() throws Exception {
        Comparator<String> comp = (first,second) ->Integer.compare(first.length(),second.length());
        int compare = comp.compare("hello", "java");
        System.out.println(compare);
    }

}
