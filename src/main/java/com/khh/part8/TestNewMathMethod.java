package com.khh.part8;

import org.junit.Test;

/**
 * Created by 951087952@qq.com on 2017/4/24.
 * 测试新的数学函数方法
 */
public class TestNewMathMethod {

    /**
     * java8  提供(add/subtract/multiply/increment/decrement/negate)Exact ,当计算溢出的时候会抛出异常
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        int j = 100000 * 100000; // 1410065408  但实际不是这个数值
        int i = Math.multiplyExact(100000, 100000);//抛出异常
    }

    /**
     * java8  提供toIntExact方法可以将一个long值转换成等价的int值
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        int i = Math.toIntExact(100L);
    }
}
