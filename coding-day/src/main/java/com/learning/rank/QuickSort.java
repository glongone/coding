package com.learning.rank;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author glong
 * @date 2019/10/15 14:50
 * 描述：快速排序
 * 基本思想： 挖坑填数+分治法。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6,7,3,2,5,9,4,1,8};
        quick(a,0, 8);
        //quickSortByStack(a);
    }

    /**
     * 快排递归形式
     *
     *
     * @param arr
     */
    public static void quick(int[] arr,int low, int high){
        if (arr.length <= 0)
            return;
        if (low >= high)
            return;
        int left = low;
        int right = high;

        // 坑1: 保存基准的值
        int temp = arr[left];
        while (left < right){
            // 坑2: 从后向前找到比基准小的元素，插入到基准位置 坑1 中
            while (left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];
            // 坑3: 从前往后找到比基准大的元素，放到上面的 坑2 中
            while (left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        // 基准值填补到坑3中，准备分支递归快排
        arr[left] = temp;
        System.out.println("Sorting: " + Arrays.toString(arr));
        quick(arr, low, left-1);
        quick(arr, left+1, high);
    }

    /**
     * 快速排序（非递归）
     *
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 把分区之后两个区间的边界（low和high）压入栈保存，并循环①、②步骤
     * @param arr   待排序数组
     */
    public static void quickSortByStack(int[] arr){
        if(arr.length <= 0) return;
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int high = stack.pop();     //出栈进行划分
            int low = stack.pop();

            int pivotIdx = partition(arr, low, high);

            //保存中间变量
            if(pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if(pivotIdx < high && pivotIdx >= 0){
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] arr, int low, int high){
        if(arr.length <= 0) return -1;
        if(low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];    //挖坑1：保存基准的值
        while(l < r){
            while(l < r && arr[r] >= pivot){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;   //基准值填补到坑3中，准备分治递归快排
        return l;
    }
}
