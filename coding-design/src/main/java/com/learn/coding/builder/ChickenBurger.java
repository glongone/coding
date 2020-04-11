package com.learn.coding.builder;

/*
 * 4.实现具体的 鸡肉汉堡价格 实例化 BaseBurger
 */
public class ChickenBurger extends BaseBurger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken BaseBurger";
    }
}