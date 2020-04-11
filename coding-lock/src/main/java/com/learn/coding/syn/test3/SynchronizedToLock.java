package com.learn.coding.syn.test3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author glong
 * @date 2019/10/14 15:03
 * 描述：
 */
public class SynchronizedToLock {
    // 实现lock接口的类
    Lock lock = new ReentrantLock();

    public synchronized void method1(){
        System.out.println("我是Synchronized形式的锁");
    }

    public void method2(){
        // 锁住
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //证明method1和method2两个方法等价
        SynchronizedToLock toLock = new SynchronizedToLock();
        toLock.method1();
        toLock.method2();
    }
}
