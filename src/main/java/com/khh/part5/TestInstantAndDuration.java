package com.khh.part5;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by 951087952@qq.com on 2017/4/24.
 * 测试Instant和DurationAPI
 */
public class TestInstantAndDuration {

    public void method1(){
        int count = 0;
        for (int i = 0; i < 10000000; i++) {
            count += i;
        }
    }

    /**
     * 求两个顺点之间的距离
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        Instant start = Instant.now();
        System.out.println(start);//2017-04-24T07:29:01.871Z
        method1();
        Instant end = Instant.now();
        System.out.println(end);//2017-04-24T07:29:02.402Z
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());//468
    }



}
