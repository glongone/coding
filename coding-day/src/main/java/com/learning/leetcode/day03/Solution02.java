package com.learning.leetcode.day03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author glongone
 * @date 2021/4/2 3:51 下午
 * @desc
 */
public class Solution02 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            int size = end - start + 1;
            ans = Math.max(ans, size);
            map.put(alpha, end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "acabasbsdfstsgsewgew";
        int n = lengthOfLongestSubstring(s);
        System.out.println(n);
    }
}
