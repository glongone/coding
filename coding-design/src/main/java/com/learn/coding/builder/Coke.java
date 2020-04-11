package com.learn.coding.builder;

/*
 * 4.实现具体的 可乐的价格 实例化 BaseColdDrink
 */
public class Coke extends BaseColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}