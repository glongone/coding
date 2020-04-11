package com.learn.coding.syn.test;

/**
 * @author glong
 * @date 2019/9/4 19:42
 * 描述： 类锁第一种形式，static形式
 */
public class SynchronizedClassStatic implements Runnable{
    static SynchronizedClassStatic instance1 = new SynchronizedClassStatic();
    static SynchronizedClassStatic instance2 = new SynchronizedClassStatic();

    @Override
    public void run() {
        method();
    }

    // 修饰的是静态方法
    public static synchronized void method(){
        System.out.println("我是类锁的第一种形式：static形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
