package com.learning.disabuse;

/**
 * @author glong
 * @date 2020/4/8 14:48
 * @desc: 4.初级问题
 */
public class Demo04 {
    /**
     * long 类型后门不用l 要用大写的L
     */
    public static void test(){
        System.out.println(12345+5432l);
    }

}
