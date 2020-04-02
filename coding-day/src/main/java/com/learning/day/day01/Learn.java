package com.learning.day.day01;

import java.util.Scanner;

/**
 * @author glong
 * @date 2020/4/2 21:55
 * @desc: 回文子串
 */

public class Learn {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s == null || s.length() == 0) {
            System.out.println(0);
        }
        char[] sChar = s.toCharArray();
        int len = sChar.length;
        int i,j,k;
        int[][] arr = new int[len][len];
        int sum = 0;
        for(i = 0; i < len; i++) {
            arr[i][i] = 1;
            sum += 1;
        }
        for(i = 2; i <= len; i++) {
            j = 0;
            k = j + i - 1;
            while(k < len) {
                if(sChar[j] == sChar[k]) {
                    if(j + 1 <= k - 1) {
                        arr[j][k] = arr[j + 1][k - 1];
                        sum += arr[j + 1][k -1];
                    }else {
                        arr[j][k] = 1;
                        sum += 1;
                    }
                }
                j++;
                k++;
            }

        }
        System.out.println(sum);
    }
}