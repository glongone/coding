package com.jvm.load;

/**
 * @author glongone
 * @date 2021/4/21 5:51 下午
 * @desc
 */
public class Math {

    public static final int initData = 666;

    public static User usr = new User();

    public int compute(){
        int a = 1;
        int b = 2;
        int c = ( a + b ) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }

}
