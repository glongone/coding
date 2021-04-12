package com.learning.leetcode.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author glongone
 * @date 2021/4/6 4:07 下午
 * @desc
 */
public class Solution02 {

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < m; i++) {
            list.add(nums1[i]);
        }
        for (int j=0; j < n; j++) {
            list.add(nums2[j]);
        }
        Collections.sort(list);
        return (list.get(left - 1) + list.get(right - 1) ) / 2.0;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};
        double dou = findMedianSortedArrays2(nums1, nums2);
        System.out.println(dou);
    }
}
