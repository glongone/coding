package com.learning.test;

/**
 * @author: glongone
 * @date: 2020/8/31 11:09 下午
 * @desc:
 */
public class Main {

    int a = 2;

    public static void main(String[] args) {
//        Main main = new Main();
//        int a = 0;
//        System.out.println(a);
//        main.a = a;
//        main.add(main);
//        a = main.a;
//        System.out.println(a);

        long startTime=System.currentTimeMillis();
        String car = "浙123123 ";
        System.out.println(isChineseChar(car.charAt(0)));
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

        //System.out.println(car.length() == car.replaceAll(" ", "").length());
    }

    /**
     * 判断一个字符是否是汉字
     * PS：中文汉字的编码范围：[\u4e00-\u9fa5]
     *
     * @param c 需要判断的字符
     * @return 是汉字(true), 不是汉字(false)
     */
    public static boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }

    public void add(Main main){
        main.a ++;
    }

}
