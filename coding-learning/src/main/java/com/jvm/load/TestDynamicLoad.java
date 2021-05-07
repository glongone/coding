package com.jvm.load;

/**
 * @author glongone
 * @date 2021/4/21 5:54 下午
 * @desc
 */
public class TestDynamicLoad {

    static {
        System.out.println("load TestDynamic");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("load test");
        B b = null;
    }
}

class A{
    static {
        System.out.println("load A");
    }

    public A() {
        System.out.println("initial A");
    }
}

class B{
    static {
        System.out.println("load B");
    }

    public B() {
        System.out.println("initial B");
    }
}
