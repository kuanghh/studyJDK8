package com.khh.part2.practices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/22.7
 * 当获得了前5个单词的长度是满足大于等于4的时候，不会再调用filter方法
 */
public class PracticeTwo {

    public static void main(String[] args) {
        String[] strings = Const.story.split("[\\P{L}]+");
        List<String> words = Arrays.asList(strings);

        Stream<String> limit = words.stream().filter(w -> {
            System.out.println("11");
            if (w.length() >= 4) {
                return true;
            } else {
                return false;
            }
        }).limit(5);

        limit.forEach(System.out::println);
    }
}
