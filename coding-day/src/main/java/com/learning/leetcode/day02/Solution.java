package com.learning.leetcode.day02;

import java.util.HashMap;

/**
 * @author: glongone
 * @date: 2020/9/7 7:42 下午
 * @desc:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                result[0] = i;
                result[1] = hash.get(nums[i]);
                return result;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return result;
    }


    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int n=0; n<nums.length; n++) {
            map.put(nums[n],n);
        }
        for (int n=0; n<nums.length; n++) {
            Integer a = map.get(target - nums[n]);
            if(null != a) {
                res[0] = n;
                res[1] = a;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] test = new int[]{3,3};
        twoSum2(test, 6);
    }
}
