package com.khh.part5;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Created by 951087952@qq.com on 2017/4/24.
 * 测试LocalDate(本地日期)API
 */
public class TestLocalDate {

    @Test
    public void test1() throws Exception{
        LocalDate today = LocalDate.now();
        LocalDate today2 = LocalDate.of(2017, 4, 24);
        LocalDate today3 = LocalDate.of(2017, Month.APRIL, 24);
        System.out.println(today.equals(today2));//true

        LocalDate afterYear = today.plus(Period.ofYears(1));//加一年
        LocalDate afterYear2 = today.plusYears(1);//加一年
        System.out.println(afterYear.equals(afterYear2));//true

        Period until = today.until(afterYear);
        System.out.println(until.getYears());//1
        System.out.println(until.getDays());//0

        long unti2 = today.until(afterYear, ChronoUnit.DAYS); //可以输出两个时间段距离之间的准确天数
        System.out.println(unti2);//365

    }
}
