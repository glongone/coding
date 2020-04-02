package com.learning.day.day03;

/**
 * @author glong
 * @date 2020/4/2 22:06
 * @desc: 二维数组中的查找
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {

    static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{2,3,4}};
        System.out.println(Find(3, array));
        System.out.println(Find(5, array));
    }
}
