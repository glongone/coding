package com.learning.rank;

import java.util.Arrays;

/**
 * @author glong
 * @date 2019/10/15 13:57
 * 描述：希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {8,7,3,2,5,4,1,6};
        shellWiki(a);
    }

    /**
     *  1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
     *  2. 按增量序列个数k，对序列进行k 趟排序；
     *  3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *   仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长
     * @param arr
     */
    public static void shell(int[] arr){
        int gap = arr.length/2;
        //不断缩小gap，直到为1为止
        for (; gap > 0; gap /= 2){
            System.out.println("shell==>>");
            // 使用当前gap进行组内插入排序
            for (int i = 0; (i+gap) < arr.length; i++) {
                System.out.println(i);
                for (int j = 0; (j+gap) < arr.length; j+=gap) {
                    if (arr[j] > arr[j+gap]){
                        int temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                        System.out.println("Sorting：" + Arrays.toString(arr));
                    }
                }
            }
        }
    }

    /**
     * WIKI官方版本
     *
     * @param arr
     */
    public static void shellWiki(int[] arr){
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len/3){
            gap = gap*3 +1;  // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        }
        for (; gap > 0; gap/=3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i-gap; j>= 0 && arr[j] > temp; j -= gap){
                    arr[j + gap] = temp;
                }
            }
        }
    }
}
