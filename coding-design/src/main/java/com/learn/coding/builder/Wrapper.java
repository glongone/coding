package com.learn.coding.builder;

// 2.添加包装的实体 Wrapper,作为默认功能
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "This is Wrapper";
    }

}
