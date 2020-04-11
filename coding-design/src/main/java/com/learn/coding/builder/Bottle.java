package com.learn.coding.builder;

// 2.实现包装的实体 Bottle
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "this is Bottle";
    }
}
