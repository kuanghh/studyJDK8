package com.khh.part2.practices;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/26.
 * 调换 first second 之间元素的位置，知道其中一个流结束为止
 *
 */
public class PractiveEight {

    public static <T>  Stream<T> zip(Stream<T> first,Stream<T> second){

        Stream<T> concat = Stream.concat(first, second);

        return null;
    }

}
