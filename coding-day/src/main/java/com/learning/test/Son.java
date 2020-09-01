package com.learning.test;

/**
 * @author: glongone
 * @date: 2020/8/31 11:13 下午
 * @desc:
 */
public class Son extends Parent {

    int age = 1;
    String name = "张三";

    public int add(int a){
        return a++;
    }

    public void add01(int a){
        a ++;
    }

    public void setName(String name){
        this.name = "王二";
    }

}
