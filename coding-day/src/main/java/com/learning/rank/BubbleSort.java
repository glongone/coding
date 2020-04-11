package com.learning.rank;

import java.util.Arrays;

/**
 * @author glong
 * @date 2019/10/15 14:52
 * 描述：冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {8,7,3,2,5,4,1,6};
        bubble(a);
    }

    /**
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * @param arr
     */
    public static void bubble(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("Sorting：" + Arrays.toString(arr));
                }
            }
        }
    }

}
