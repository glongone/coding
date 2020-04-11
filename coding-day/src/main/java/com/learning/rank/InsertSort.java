package com.learning.rank;

import java.util.Arrays;

/**
 * @author glong
 * @date 2019/10/15 13:40
 * 描述：插入排序
 *
 * 1. 从第一个元素开始，该元素可以认为已经被排序
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5. 将新元素插入到该位置后
 * 6. 重复步骤2~5
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {8,7,3,2,5,4,1,6};
        insert(a);
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insert(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            System.out.println("===" + i);
            for (int j = i+1; j > 0; j--) {
                if (arr[j-1] <= arr[j])
                    break;
                int index = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = index;
                System.out.println("Sorting：" + Arrays.toString(arr));
            }
        }
    }
}
