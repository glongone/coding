package com.learning.disabuse;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

/**
 * @author glong
 * @date 2020/4/8 15:20
 * @desc: 6.多重转型
 */
public class Demo06 {
    public static void main(String[] args) {
        System.out.println((int)(char)(byte) -1);
        test();
    }

    public static void test(){
        int i = -1 & 0xffff;
        byte b = (byte) i;
        char c = (char) (b & 0xff);
        System.out.println((int) (c & 0xff));
    }
}
