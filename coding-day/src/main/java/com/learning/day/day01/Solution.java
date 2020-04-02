package com.learning.day.day01;

/**
 * @author glong
 * @date 2020/4/2 22:03
 * @desc: 字符串替换
 */
public class Solution {

    public String replaceSpace(StringBuffer str) {
        String str0 = str.toString();
        str0 = str0.replaceAll(" ", "%20");
        return str0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace(new StringBuffer("We are happy")));
    }
}
