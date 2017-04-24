package com.khh.part5;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 * Created by 951087952@qq.com on 2017/4/24.
 * 测试LocalTime（本地时间）Api
 */
public class TestLocalTime {

    /**
     * LocalTime表示一天中的某个时间
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        LocalTime now = LocalTime.now();
        System.out.println(now);//  15:31:34.576
    }

    /**
     * LocalDateTime 表示一天日期和时间
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);// 2017-04-24T15:33:22.898
    }
}
