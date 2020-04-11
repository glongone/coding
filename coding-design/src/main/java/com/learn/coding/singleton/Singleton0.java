package com.learn.coding.singleton;

/**
 * 单例模式：懒汉式1
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 不支持多线程，没有加锁synchronized
 * */

public class Singleton0 extends Singleton{

    private static Singleton0 instance;
    private Singleton0(){}

    public static Singleton0 getSingleton(){
        if (instance == null) {
            instance = new Singleton0();
        }
        return instance;
    }

    @Override
    void showMessage() {
        System.out.println("懒汉式1");
    }
}
