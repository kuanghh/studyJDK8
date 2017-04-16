package com.khh.part1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by 951087952@qq.com on 2017/4/14.
 * 测试   默认方法
 */
public class TestDefaultMethod {

    @Test
    public void test1() throws Exception{
        List<Integer> list = Arrays.asList(1,2,3);
        list.forEach(System.out::println);
        //Console:
        //          1
        //          2
        //          3
    }

    @Test
    public void test2() throws Exception{

    }
}
