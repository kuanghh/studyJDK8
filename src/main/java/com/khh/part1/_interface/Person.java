package com.khh.part1._interface;

/**
 * Created by 951087952@qq.com on 2017/4/14.
 */
public interface Person {
    long getId();
    default String getName(){return "John Q.Public";}
}
