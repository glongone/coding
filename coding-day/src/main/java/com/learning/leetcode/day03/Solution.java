package com.learning.leetcode.day03;

import java.util.*;

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


    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char alp = s.charAt(end);
            if (map.containsKey(alp)) {
                start = Math.max(map.get(alp), start);
            }
            ans = Math.max(end - start + 1, ans);
            map.put(alp, end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sum = solution.lengthOfLongestSubstring2("abcabcbb");
        System.out.println(solution.sum);
//        String s = "abcabcbb";
//        s = s.replaceAll(String.valueOf(s.charAt(0)), "");
//        System.out.println(s);
//        System.out.println(s.length());
    }
}
