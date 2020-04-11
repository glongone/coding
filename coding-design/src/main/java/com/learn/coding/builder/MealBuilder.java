package com.learn.coding.builder;

/**
 * 表示一擦中食物搭配的情况，进行费用统计
 * */

public class MealBuilder {

    // 第一种餐饮搭配
    public Meal prepareFirstMeal (){
        Meal meal = new Meal();
        meal.addItem(new Coke());
        return meal;
    }

    // 第二种餐饮搭配
    public Meal prepareSeconedMeal (){
        Meal meal = new Meal();
        meal.addItem(new Coke());
        meal.addItem(new ChickenBurger());
        return meal;
    }
}