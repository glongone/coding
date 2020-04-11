package com.learn.coding.builder;

/**
 * 演示结果显示每一种点餐的，餐饮中的食物情况
 * */

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal firstMeal = mealBuilder.prepareFirstMeal();
        System.out.println("First Meal");
        firstMeal.showItems();
        System.out.println("Total Cost: " +firstMeal.getCost());

        Meal seconedMeal = mealBuilder.prepareSeconedMeal();
        System.out.println("\n\nNon-Veg Meal");
        seconedMeal.showItems();
        System.out.println("Total Cost: " +seconedMeal.getCost());
    }
}