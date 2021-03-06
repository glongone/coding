package com.learning.disabuse;

import java.math.BigDecimal;

/**
 * @author glong
 * @date 2020/4/8 13:41
 * @desc: 2.找零时刻
 */
public class Demo02 {

    /**
     * Tom 在一家汽车配件商店购买了一个价值$1.10 的火花塞，但是他钱包中都是两
     * 美元一张的钞票。如果他用一张两美元的钞票支付这个火花塞，那么应该找给他
     * 多少零钱呢？
     * 下面是一个试图解决上述问题的程序，它会打印出什么呢？
     */
    public static void main(String[] args) {
        System.out.println(2.00 - 1.10);
    }

    /**
     * 你可能会很天真地期望该程序能够打印出 0.90，但是它如何才能知道你想要打
     * 印小数点后两位小数呢？
     * 如果你对在 Double.toString 文档中所设定的将 double 类型的值转换为字符串
     * 的规则有所了解，你就会知道该程序打印出来的小数，是足以将 double 类型的
     * 值与最靠近它的临近值区分出来的最短的小数，它在小数点之前和之后都至少有
     * 一位。因此，看起来，该程序应该打印 0.9 是合理的。
     * 这么分析可能显得很合理，但是并不正确。如果你运行该程序，你就会发现它打
     * 印的是 0.8999999999999999。
     * 问题在于 1.1 这个数字不能被精确表示成为一个 double，因此它被表示成为最
     * 接近它的 double 值。该程序从 2 中减去的就是这个值。遗憾的是，这个计算的
     * 结果并不是最接近 0.9 的 double 值。表示结果的 double 值的最短表示就是你所
     * 看到的打印出来的那个可恶的数字。
     * 更一般地说，问题在于并不是所有的小数都可以用二进制浮点数来精确表示的。
     * 如果你正在用的是 JDK 5.0 或更新的版本，那么你可能会受其诱惑，通过使用
     * printf 工具来设置输出精度的方订正该程序：
     * //拙劣的解决方案——仍旧是使用二进制浮点数
     * System.out.printf("%.2f%n",2.00 - 1.10);
     * 这条语句打印的是正确的结果，但是这并不表示它就是对底层问题的通用解决方
     * 案：它使用的仍旧是二进制浮点数的 double 运算。浮点运算在一个范围很广的
     * 该书下载自-书部落-分享计算机经典巨著！ --www.shubulo.com!仅供试看^_^值域上提供了很好的近似，
     * 但是它通常不能产生精确的结果。二进制浮点对于货
     * 币计算是非常不适合的，因为它不可能将 0.1——或者 10 的其它任何次负幂——
     * 精确表示为一个长度有限的二进制小数
     * 解决该问题的一种方式是使用某种整数类型，例如 int 或 long，并且以分为单
     * 位来执行计算。如果你采纳了此路线，请确保该整数类型大到足够表示在程序中
     * 你将要用到的所有值。对这里举例的谜题来说，int 就足够了。下面是我们用 int
     * 类型来以分为单位表示货币值后重写的 println 语句。这个版本将打印出正确答
     * 案 90 分：
     * System.out.println((200 - 110) + "cents");
     *
     * 解决该问题的另一种方式是使用执行精确小数运算的 BigDecimal。它还可以通
     * 过 JDBC 与 SQL DECIMAL 类型进行互操作。这里要告诫你一点： 一定要用
     * BigDecimal(String)构造器，而千万不要用 BigDecimal(double)。
     *
     * 这个版本并不是十分地完美，因为 Java 并没有为 BigDecimal 提供任何语言上的
     * 支持。使用 BigDecimal 的计算很有可能比那些使用原始类型的计算要慢一些，
     * 对某些大量使用小数计算的程序来说，这可能会成为问题，而对大多数程序来说，
     * 这显得一点也不重要。
     * 总之， 在需要精确答案的地方，要避免使用 float 和 double；对于货币计算，
     * 要使用 int、long 或 BigDecimal。对于语言设计者来说，应该考虑对小数运算
     * 提供语言支持。一种方式是提供对操作符重载的有限支持，以使得运算符可以被
     * 塑造为能够对数值引用类型起作用，例如 BigDecimal。另一种方式是提供原始
     * 的小数类型，就像 COBOL 与 PL/I 所作的一样
     */
    public static void test(){
        double a = 2.00;
        double b = 1.10;
        double c = a - b;
        System.out.println(a-b);
        System.out.println(c);
        System.out.println(new BigDecimal(.1));
        System.out.println(new BigDecimal(".1"));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }

}
/*
0.8999999999999999
0.8999999999999999
0.8999999999999999
0.1000000000000000055511151231257827021181583404541015625
0.1
0.90
*/