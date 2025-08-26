package com.learning.go;

/**
 * @author gaobenlong
 * @date 2024/11/4 23:11
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }
        int n = s.length();

        int start = 0, end = 1;
        int max = 1;

        String ab = s.substring(0,1);
        for (int i = 2; i < n; i++) {
            if (ab.contains(s.charAt(i))) {
                start = ab.indexOf(s.charAt(i));
            }
            end = i;
            max = Math.max(max, end - start);
        }


        return max;

    }
}
