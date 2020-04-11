package com.learn.coding.syn.test;

/**
 * @author glong
 * @date 2019/9/4 20:04
 * 描述：
 */
public class DisappearRequest2 implements Runnable{
    static DisappearRequest2 instance = new DisappearRequest2();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }


}
