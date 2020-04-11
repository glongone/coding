package com.learn.coding.syn.test3;

/**
 * @author glong
 * @date 2019/10/10 20:28
 * 描述：  可重入粒度测试：递归调用本方法
 */
public class SynchronizedRecursion {
    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion synchronizedRecursion = new SynchronizedRecursion();
        synchronizedRecursion.method1();
    }

    private synchronized void method1(){
        System.out.println("这是method1,a=" + a);
        if (a ==0 ){
            a++;
            method1();
        }
    }
}
