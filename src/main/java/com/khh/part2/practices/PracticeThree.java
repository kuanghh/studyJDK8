package com.khh.part2.practices;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 951087952@qq.com on 2017/4/22.
 * parallelStream()  比  stream() 快
 *
 */
public class PracticeThree {

    public static void userParallelStream(List<String> words){
        long start = System.nanoTime();
        long count = words.parallelStream().filter(w -> w.length() > 5).count();
        long end = System.nanoTime();
        System.out.println(end - start); //88002497

    }

    public static void userStream(List<String> words){
        long start = System.nanoTime();
        long count = words.stream().filter(w -> w.length() > 5).count();
        long end = System.nanoTime();
        System.out.println(end - start); //90134061
    }

    public static void main(String[] args) {
        String[] strings = Const.story.split("[\\P{L}]+");
        List<String> words = Arrays.asList(strings);

        userStream(words);

        //userParallelStream(words);
    }
}
