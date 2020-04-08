package com.learning.disabuse;

/**
 * @author glong
 * @date 2020/4/8 14:49
 * @desc: 5.十六进制的趣事
 */
public class Demo05 {
    /**
     * 下面的程序是对两个十六进制（hex）字面常量进行相加，然后打印出十六进制
     * 的结果。这个程序会打印出什么呢？
     */
    public static void main(String[] args){
        // 在这个程序中，数字 0xcafebabe
        // 是一个 int 常量，它的最高位被置位了，所以它是一个负数。它等于十进制数值
        // -889275714。
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
    }

    /**
     * 这个加法的右操作数 0xcafebabe 被提升为了 long 类型的数值
     * 0xffffffffcafebabeL。这个数值之后被加到了左操作数 0x100000000L 上。当作
     * 为 int 类型来被审视时，经过符号扩展之后的右操作数的高 32 位是-1，而左操
     * 作数的高 32 位是 1，将这两个数值相加就得到了 0，这也就解释了为什么在程序
     * 输出中前导 1 丢失了。下面所示是用手写的加法实现。（在加法上面的数字是进
     * 位。）
     *
     *
     * 1111111
     *   0xffffffffcafebabeL
     * + 0x0000000100000000L
     * ---------------------
     *   0x00000000cafebabeL
     *
     *   订正该程序非常简单，只需用一个 long 十六进制字面常量来表示右操作数即可。
     * 这就可以避免了具有破坏力的符号扩展，并且程序也就可以打印出我们所期望的
     * 结果 1cafebabe
     */
    public static void test(){
        System.out.println(
                Long.toHexString(0x100000000L + 0xcafebabeL));
    }
}
