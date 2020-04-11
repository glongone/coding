package com.learn.coding.syn.test;

/**
 * @author glong
 * @date 2019/9/4 18:28
 * 描述： 对象锁示例1，代码块形式
 */
public class SynchronizedObjectCodeBlock implements Runnable{

    static SynchronizedObjectCodeBlock instance = new SynchronizedObjectCodeBlock();

    Object lock1 = new Object();
    Object lock2 =new Object();

    // 对象锁的代码块形式
    @Override
    public void run() {
        // 保证串行执行
        synchronized (lock1) {
            System.out.println("我是lock1。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",lock1运行结束");
        }
        synchronized (lock2) {
            System.out.println("我是lock2。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",lock2运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
