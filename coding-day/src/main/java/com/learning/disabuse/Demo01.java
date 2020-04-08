package com.learning.disabuse;

/**
 * @author glong
 * @date 2020/4/8 13:44
 * @desc: 1.奇数性
 *
 * 总之，无论你何时使用到了取余操作符，都要考虑到操作数和结果的符号。该操
 * 作符的行为在其操作数非负时是一目了然的，但是当一个或两个操作数都是负数
 * 时，它的行为就不那么显而易见了
 */
public class Demo01 {

    /**
     * 当 i 是一个负奇数时，i % 2 等于-1 而不是 1， 因此 isOdd 方法将错误地返
     * 回 false。为了防止这种意外，请测试你的方法在为每一个数值型参数传递负数、
     * 零和正数数值时，其行为是否正确。
     * @param i 求奇的值
     * @return 判断结果
     */
    public static boolean isOdd(int i){
        return i % 2 == 1;
    }

    /**
     * 更好的做法
     * @param i 求奇的值
     * @return 判断结果
     */
    public static boolean isOdd01(int i){
        return i % 2 != 0;
    }

    /**
     * 如果你正在在一个性能临界（performance-critical）环境中使用 isOdd 方法，
     * 那么用位操作符 AND（&）来替代取余操作符会显得更好：
     * @param i 求奇的值
     * @return 判断结果
     */
    public static boolean isOdd02(int i){
        return (i & 1) != 0;
    }

}
