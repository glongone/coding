package com.learn.coding.singleton;

/**
 * 单例模式：双检锁/双重校验锁 DCL
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 */

public class Singleton2 extends Singleton{
    private volatile static Singleton2 singleton;

    private Singleton2 (){}

    public static Singleton2 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }

    @Override
    void showMessage() {
        System.out.println("双检锁/双重校验锁（DCL，即 double-checked locking）");
    }
}
