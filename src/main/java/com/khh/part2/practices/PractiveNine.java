package com.khh.part2.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/26.
 * 将一个Stream<ArrayList<T>>中的全部元素连接为一个ArrayList<T>
 */
public class PractiveNine {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("123");
        list1.add("456");
        list1.add("789");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("abc");
        list2.add("def");
        list2.add("ghj");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("a11");
        list3.add("b22");
        list3.add("c33");

        Stream<ArrayList<String>> listStream = Stream.of(list1, list2, list3);
        ArrayList<String> reduce = listStream.reduce( new ArrayList<>(), (x, y) -> {
            x.addAll(y);
            return x;
        });
        reduce.forEach(System.out::println);
    }
}
