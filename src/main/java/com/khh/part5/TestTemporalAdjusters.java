package com.khh.part5;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by 951087952@qq.com on 2017/4/24.
 * 测试TemporalAdjusters(时间校正器)API
 */
public class TestTemporalAdjusters {

    /**
     * 计算某个月的第一个周二
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        int year = 2017;
        int month = 4;
        LocalDate date = LocalDate.of(year, month, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
        System.out.println(date);//2017-04-06
    }

    /**
     * 自定义一个时间校正器
     */
    @Test
    public void test2() throws Exception {


    }
}