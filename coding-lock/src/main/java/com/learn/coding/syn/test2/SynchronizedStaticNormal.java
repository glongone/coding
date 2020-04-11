package com.learn.coding.syn.test2;

import com.test.SynchronizedClassStatic;

/**
 * @author glong
 * @date 2019/9/4 20:42
 * 描述：
 */
public class SynchronizedStaticNormal implements Runnable{
    static SynchronizedStaticNormal instance = new SynchronizedStaticNormal();
//    static SynchronizedStaticNormal instance2 = new SynchronizedStaticNormal();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        } else {
            method2();
        }
    }

    // 静态类锁(类对象)
    public synchronized static void method1(){
        System.out.println("我是静态加锁的方法1。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    // 普通方法锁（实例对象锁）
    public synchronized void method2(){
        System.out.println("我是非静态加锁的方法2。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }


}
