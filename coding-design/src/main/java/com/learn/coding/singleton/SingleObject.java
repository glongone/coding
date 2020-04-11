package com.learn.coding.singleton;

/**
 * @author glong
 *
 * 单例模式：饿汉式
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 */
public class SingleObject extends Singleton {

    // 创建对象
    private static SingleObject instance = new SingleObject();

    // 让构造函数为 private,这样该类就不会被实例化
    private SingleObject(){}

    // 获取唯一可用的对象
    public static SingleObject getSingleton(){
        return instance;
    }

    public void showMessage(){
        System.out.println("饿汉式单例");
    }

}
