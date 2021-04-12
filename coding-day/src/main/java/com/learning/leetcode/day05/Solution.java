package com.learning.leetcode.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author glongone
 * @date 2021/4/6 5:02 下午
 * @desc
 */
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), ans = 0, start1 = 0;
        StringBuffer res = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char alp = s.charAt(end);
            if (res.toString().charAt(0) == alp) {
                start = Math.max(map.get(alp), start);
            }
            ans = Math.max(end - start + 1, ans);
            map.put(alp, end + 1);
        }

        return res.toString();
    }
}
