package com.learning.leetcode.day03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: glongone
 * @date: 2020/9/14 10:24 上午
 * @desc:
 */
public class Solution {
    public int sum = 0;

    public int lengthOfLongestSubstring(String s) {
        //String ss = new String(s);
        if(s.length() == 0)
            return sum;
        sum++;
        s = s.replaceAll(String.valueOf(s.charAt(0)), "");
        lengthOfLongestSubstring(s);
        return sum;
    }

    public void getLength(String str){
        if (str.length() == 0)
            return;
        sum ++;
        int len;

        String[] ss = str.replaceAll(String.valueOf(str.charAt(0)), " ").split(" ");
        for (String s : ss) {
            s = s.trim();

        }
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.lengthOfLongestSubstring("abcabcbb");
//        System.out.println(solution.sum);
//        String s = "abcabcbb";
//        s = s.replaceAll(String.valueOf(s.charAt(0)), "");
//        System.out.println(s);
//        System.out.println(s.length());
    }
}
