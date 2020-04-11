package com.learn.coding.builder;

// 3.创建实现 Item接口的抽象类，该类提供了 默认！ 的功能
public abstract class BaseBurger implements Item {

    // 重写 Item 中的方法,创建 Packing 的实体对象
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}
