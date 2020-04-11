package com.learn.coding.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 一餐的食物消费统计 食物价格累加 按餐 考虑总价进行消费
 * */
public class Meal {
    // list用于统计一餐中的各个食物数据
    private List<Item> items = new ArrayList<Item>();

    // 添加食物
    public void addItem(Item item){
        items.add(item);
    }

    // 统计价格
    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    // 输出一餐的事务情况
    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}