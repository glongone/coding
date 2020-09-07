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

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{2,3,4}};
        System.out.println(Find(3, array));
        System.out.println(Find(5, array));

        int a = 7;
        int arr[][] = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Find2(a,arr);
    }

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

    public static boolean Find2(int target, int [][] array) {
        int hig = array.length;
        int leg = array[0].length;
        int low = (array.length +1)/2;
        int row = (array[0].length + 1)/2;

        if (target == array[row-1][low-1]){
            return true;
        }else if (target > array[row-1][low-1]){
            int [][] arr = new int[hig-low][leg-row];
            for (int i = low, a=0; i < hig; i++, a++) {
                for (int j = row, b=0; j < leg; j++, b++) {
                    arr[a][b] = array[low][row];
                }
            }
            Find2(target, arr);
        } else {
            int [][] arr = new int[low][hig];
            for (int i = low-1, a=0; i >= 0; i--, a++) {
                for (int j = row-1, b=0; j >=0 ; j--, b++) {
                    arr[a][b] = array[low][row];
                }
            }
            Find2(target, arr);
        }

        return false;
    }

}
