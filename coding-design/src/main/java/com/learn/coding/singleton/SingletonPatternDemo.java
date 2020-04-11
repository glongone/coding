package com.learn.coding.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        // 不合法的构造函数
        // 编译时错误：构造函数 SingleObject() 是不可见的
        // SingleObject object = new SingleObject();

        // 获取唯一可用对象
//        Singleton object = SingleObject.getSingleton();
//        Singleton object = Singleton0.getSingleton();
//        Singleton object = Singleton1.getSingleton();
        Singleton object = Singleton2.getSingleton();

        // 显示提示
        object.showMessage();
    }
}
