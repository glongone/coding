package com.learning.rank;

import java.util.Arrays;

/**
 * @author glong
 * @date 2019/10/15 14:31
 * 描述： 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {8,7,3,2,5,4,1,6};
        selectSort(a);
    }

    /**
     * 1. 从待排序序列中，找到关键字最小的元素；
     * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     *      仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // 本次排序最小值位置
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                        min = j;
                }
            }
            // 判断交换条件
            if (i != min){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                System.out.println("Sorting：" + Arrays.toString(arr));
            }
        }

    }
}
