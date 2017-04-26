package com.khh.part2.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/26.
 *  改善方法characterStream代码
 */
public class PracticeSix {
    public static Stream<Character> characterStream(String s){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            list.add(s.toCharArray()[i]);
        }
        return list.stream();
    }

    /**
     * 改善后的代码
     * @param s
     * @return
     */
    public static Stream<Character> characterStreamEX(String s){
        IntStream intstream = IntStream.iterate(0,n -> n+1).limit(s.length());
        return intstream.mapToObj(s::charAt);
    }

    /**
     * 代码改短了，但性能反而差了
     * @param args
     */
    public static void main(String[] args) {
        String str = "abcdefgasdfasfasfdfsdfsf";
//        Long start = System.currentTimeMillis();
//        Stream<Character> stream1 = characterStream(str);
//        Long end = System.currentTimeMillis();
//        System.out.println(end - start); //3

        Long start = System.currentTimeMillis();
        Stream<Character> stream2 = characterStreamEX(str);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);  //109


//        stream1.forEach(System.out::println);
//        System.out.println("------------------------------");
//        stream2.forEach(System.out::println);
    }
}
