package com.util.sort;

import java.util.Arrays;

/**
 * @author glongone
 * @date 2021/6/30 7:39 下午
 * @desc 排序算法
 */
public class NumberSort {

	public static void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					System.out.println("arr:" + Arrays.toString(arr));
				}
			}
		}
	}

	public static void bubbleSort2(int[] arr) {
		for (int i = arr.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					System.out.println("arr:" + Arrays.toString(arr));
				}
			}
		}
	}

	public static int[] bubblesort(int[] nums) {
		boolean ordered = true;
		for (int i = nums.length - 1;i > 0; i--) {
			for (int j = 0; j >= nums[j + 1] ; j++ ) {
				int tmp = nums[j + 1];
				nums[j + 1] = nums[j];
				nums[j] = tmp;
				ordered = false;
			}
		}
		if (ordered == true){
			return nums;
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{7,3,8,6,4,5,2,1};
		bubbleSort2(arr);


	}

}
