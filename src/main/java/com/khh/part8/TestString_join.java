package com.khh.part8;

/**
 * Created by 951087952@qq.com on 2017/4/24.
 * java 8 字符串新特性
 */
public class TestString_join {

    /**
     * join方法
     * @param args
     */
    public static void main(String[] args) {
        String joined = String.join("/","user","local","bin");
        System.out.println(joined);//     user/local/bin
    }

}
