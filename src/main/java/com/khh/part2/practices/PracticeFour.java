package com.khh.part2.practices;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/22.
 *
 */
public class PracticeFour {

    public static void main(String[] args) {
        int[] values = {1,4,9,16};
        Stream<int[]> stream = Stream.of(values);

        IntStream intstream = IntStream.of(values);
        intstream.forEach(System.out::println);

    }
}
