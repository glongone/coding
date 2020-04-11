package com.learn.coding.syn.test;

/**
 * @author glong
 * @date 2019/9/4 19:19
 * 描述：  对象锁示例2：普通方法锁形式
 */
public class SynchronizedObjectMethod implements Runnable{

    static SynchronizedObjectMethod instance1 = new SynchronizedObjectMethod();
//    static SynchronizedObjectMethod instance2 = new SynchronizedObjectMethod();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance1);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

}
