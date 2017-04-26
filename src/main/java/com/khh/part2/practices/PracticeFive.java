package com.khh.part2.practices;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/22.
 *
 * 使用Stream.iterate来得到一个包含随机数字的无限流
 */
public class PracticeFive {

    public static UnaryOperator<Long> calc(long a, long c ,long m){
        return n -> (n * a + c) % m;
    }


    public static void main(String[] args) {
//        Stream<Long> stream = Stream.iterate(0L, n -> (n * 25214903917L + 11) % Double.valueOf(Math.pow(2,48)).longValue());
        Stream<Long> stream = Stream.iterate(0L, calc(25214903917L,11,Double.valueOf(Math.pow(2,48)).longValue()));
        Stream<Long> limit = stream.limit(5);
        limit.forEach(System.out::println);


    }
}
