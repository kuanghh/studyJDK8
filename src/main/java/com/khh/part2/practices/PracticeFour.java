package com.khh.part2.practices;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/22.
 *
 *  存在一个数组  int[] values = {1,4,9,16};
 *  则Stream.of（values）的结果是  得到一个  数组类型的流
 *  可以通过Instream.of（int数组类型）得到一个int类型的流
 */
public class PracticeFour {

    public static void main(String[] args) {
        int[] values = {1,4,9,16};
        Stream<int[]> stream = Stream.of(values);

        IntStream intstream = IntStream.of(values);
        intstream.forEach(System.out::println);

    }
}
