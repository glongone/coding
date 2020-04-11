package com.learn.coding.syn.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author glong
 * @date 2019/10/14 16:29
 * 描述：展示LOCK方法
 */
public class LockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
        //lock.tryLock(100, TimeUnit.SECONDS);
    }
}
