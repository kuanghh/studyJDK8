package com.khh.part5;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by 951087952@qq.com on 2017/4/24.
 * 测试ZoneId  ZonedDateTime  API
 */
public class TestZone {

    @Test
    public void test1() throws Exception{
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);//Asia/Shanghai
    }

    /**
     * 将 LocalDateTime 对象转换成ZonedDateTime对象
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(zoneId);
        System.out.println(zonedDateTime);//2017-04-24T15:45:17.968+08:00[Asia/Shanghai]
        ZonedDateTime berlin = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
        System.out.println(berlin);//2017-04-24T09:45:17.968+02:00[Europe/Berlin]
    }
}
