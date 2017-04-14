package com.khh.part1;

import org.junit.Test;


import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/14.
 * 测试 lambda构造器引用
 */
public class TestConstructorReference {

    @Test
    public void test1() throws Exception{
        List<String> labels = Arrays.asList("hello","java","groovy");
        Stream<Button> stream = labels.stream().map(Button::new);
        List<Button> buttons = stream.collect(Collectors.toList());
    }

}
