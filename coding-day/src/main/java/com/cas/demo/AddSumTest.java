package com.cas.demo;

/**
 * @author glongone
 * @date 2021/4/19 1:48 下午
 * @desc
 */
public class AddSumTest {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i*i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
    }
}
