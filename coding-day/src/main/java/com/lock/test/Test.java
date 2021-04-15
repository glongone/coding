package com.lock.test;

import sun.misc.Contended;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author glongone
 * @date 2021/4/12 2:08 下午
 * @desc
 */
public class Test {

//    public static AtomicInteger num = new AtomicInteger(0);
    public static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000000000; i++) {
//                num.getAndAdd(1);
                num++;
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        System.out.println("vvv");
        Thread.sleep(1000);
        System.out.println("test");
        System.out.println(num);
    }

}
