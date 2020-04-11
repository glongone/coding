package com.learn.coding.builder;

/**
 * 建造者模式
 * 优点： 1、建造者独立，易扩展。 2、便于控制细节风险。
 * 缺点： 1、产品必须有共同点，范围有限制。 2、如内部变化复杂，会有很多的建造类。
 * 使用场景： 1、需要生成的对象具有复杂的内部结构。 2、需要生成的对象内部属性本身相互依赖。
 * */

// 1.食物接口
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
