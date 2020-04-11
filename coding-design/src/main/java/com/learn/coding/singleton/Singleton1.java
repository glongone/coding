package com.learn.coding.singleton;

/**
 * 单例模式：懒汉式2
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 * */

public class Singleton1 extends Singleton {

    private static Singleton1 instance;
    private Singleton1 (){}

    public static synchronized Singleton1 getSingleton() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }


    @Override
    void showMessage() {
        System.out.println("懒汉式2");
    }
}
