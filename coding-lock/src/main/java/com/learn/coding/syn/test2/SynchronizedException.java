package com.learn.coding.syn.test2;

/**
 * @author glong
 * @date 2019/9/4 21:10
 * 描述： 方法抛出异常后，会释放锁，展示不抛出异常前和抛出异常后
 * 对比：一旦抛出了异常，第二个线程会立刻进入同步方法，意味着锁已经释放。
 */
public class SynchronizedException implements Runnable{
    static SynchronizedException instance = new SynchronizedException();

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

    public synchronized void method1(){
        System.out.println("我是加锁的方法1。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
//            throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 真正的在同步方法中抛出异常，没有被任何捕获
        throw new RuntimeException();
//        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是加锁的方法2。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

}
