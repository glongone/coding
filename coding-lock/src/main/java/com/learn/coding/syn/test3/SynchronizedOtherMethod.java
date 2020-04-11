package com.learn.coding.syn.test3;

/**
 * @author glong
 * @date 2019/10/10 20:34
 * 描述：可重入粒度测试：调用类内的另外的方法
 */
public class SynchronizedOtherMethod {
    public static void main(String[] args) {
        SynchronizedOtherMethod otherMethod = new SynchronizedOtherMethod();
        otherMethod.method1();
    }

    public synchronized void method1(){
        System.out.println("我是方法一");
        method2();
    }

    public synchronized void method2() {
        System.out.println("我是方法二");
    }
}
