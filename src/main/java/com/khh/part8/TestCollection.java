package com.khh.part8;


import com.khh.part8.bean.Person;
import org.junit.Test;


import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * Created by 951087952@qq.com on 2017/4/24.
 * 测试集合类
 */
public class TestCollection {

    public static String[] firstNames = {"monkey","monkey","tom","xiaoming","wangqiang"};

    public static String[] lastNames = {"monkey","mike","tom","xiaoming","wangqiang"};

    public static List<Person> persons ;

    public static int i = 0;

    static{
        persons = new ArrayList<>();
        for (int i = 0; i < (firstNames.length > lastNames.length ? firstNames.length:lastNames.length); i++) {
            persons.add(new Person(firstNames[i],lastNames[i]));
        }
    }

    /**
     * Iterator接口的forEachRemaining方法，能够将剩余的迭代元素都传递给一个函数
     * @throws Exception
     */
    @Test
    public void test1() throws  Exception{
        List<String> list = Arrays.asList(firstNames);
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(System.out::println);
    }


    /**
     * Comparator.coparing
     * @throws Exception
     */
    @Test
    public void test2() throws  Exception{
        Person[] ps = TestCollection.persons.toArray(new Person[]{});
        Arrays.sort(ps, Comparator.comparing(Person::getFirstName,compareLength()).thenComparing(Person::getLastName,compareLength()));
        Arrays.asList(ps).forEach(System.out::println);
    }

    public static Comparator<String> compareLength(){
        return(String a, String b) -> Integer.compare(a.length(), b.length());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void test3() throws  Exception{
        List<String> strings = Arrays.asList(lastNames);
        NavigableSet<String> set = new TreeSet<>(strings);
        NavigableSet<String> ts = Collections.unmodifiableNavigableSet(set);
        String tom = ts.floor("to");
        System.out.println(tom);
    }

    /**
     * bitSet最低的长度为64,默认长度也为64
     * @throws Exception
     */
    @Test
    public void test4() throws  Exception{
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.size());  //64

        BitSet bitSet2 = new BitSet(32);
        System.out.println(bitSet2.size());  //64

        BitSet bitSet3 = new BitSet(128);
        System.out.println(bitSet3.size());  //128
    }

    /**
     *  set（int index） 方法把 index位置的数字由0变成1
     *  clear(int index) 方法把 index位置的数字变成0
     *  默认全部位置的数字都为0
     * @throws Exception
     */
    @Test
    public void test5() throws  Exception{
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        System.out.println(bitSet.get(0));//true
        System.out.println(bitSet.get(1));//false
        bitSet.clear(0);
        System.out.println(bitSet.get(0));//false
        System.out.println((byte)0b10101100);
    }




    /**
     *
     * @throws Exception
     */
    @Test
    public void testn() throws  Exception{
        byte[] bytes = {(byte)0b10101100,(byte)0b00101000};
        BitSet primes = BitSet.valueOf(bytes);
        System.out.println(primes.size());//64
        primes.stream().forEach(System.out::println);
        /**
         * 2
         * 3
         * 5
         * 7
         * 11
         * 13
         */
    }

}
