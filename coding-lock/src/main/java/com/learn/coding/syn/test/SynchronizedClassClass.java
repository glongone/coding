package com.learn.coding.syn.test;

/**
 * @author glong
 * @date 2019/9/4 19:53
 * 描述： 类锁的第二种形式: synchronized(*.class)形式
 */
public class SynchronizedClassClass implements Runnable {
    static SynchronizedClassClass instance1 = new SynchronizedClassClass();
    static SynchronizedClassClass instance2 = new SynchronizedClassClass();

    @Override
    public void run() {
        method();
    }

    // synchronized(*.class)方式
    private void method(){
        synchronized (SynchronizedClassClass.class){
            System.out.println("我是类锁的第二种形式：synchronized(*.class)形式，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
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
