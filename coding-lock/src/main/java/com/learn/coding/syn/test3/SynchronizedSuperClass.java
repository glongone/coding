package com.learn.coding.syn.test3;

/**
 * @author glong
 * @date 2019/10/10 20:37
 * 描述：  可重入粒度测试，调用父类的方法
 */
public class SynchronizedSuperClass {
    public synchronized void doSomething(){
        System.out.println("我是父类方法");
    }

}

class TestClass extends SynchronizedSuperClass{

    public synchronized void doSomething(){
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomething();
    }
}