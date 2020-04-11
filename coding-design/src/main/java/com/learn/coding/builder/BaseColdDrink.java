package com.learn.coding.builder;

// 3.创建实现 Item接口的抽象类，该类提供了 默认！ 的功能
public abstract class BaseColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
