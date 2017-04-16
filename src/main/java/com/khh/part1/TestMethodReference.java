package com.khh.part1;

import org.junit.Test;

import java.util.Arrays;


/**
 * Created by 951087952@qq.com on 2017/4/14.
 * 测试  方法引用
 */
public class TestMethodReference {

    @Test
    public void test1() throws Exception{
        //假设不区分大小写地对字符串进行排序
        String[] words = {"hello","java","groovy"};
        Arrays.sort(words,String::compareToIgnoreCase);
        System.out.println(Arrays.asList(words));
        //Console : [groovy, hello, java]
        //::操作符将方法名和对象或类的名字分隔开来。以下是三种主要的使用情况：
        //对象::实例方法
        //类::静态方法
        //类::实例方法 此情况下-->第一个参数会成为执行方法的对象
                    //例如：String :: compareToIgnoreCase 等同于
                    //      (x,y) -> x.compareToIgnoreCase(y)
                    //还可以捕获方法引用中的this参数
                    //this::equals 等同于 x->this.equals(x);
    }

    static class Greeter{
        public void greet(){
            System.err.println("Hello , world!");
        }
    }

    static class ConcurrentGreeter extends Greeter{
        public void greet(){
            new Thread(super::greet).start();
        }

    }
    @Test
    public void test2() throws Exception{
        ConcurrentGreeter c1 = new ConcurrentGreeter();
        c1.greet();
        //Console : "Hello , world!"
    }
}
