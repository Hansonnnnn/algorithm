package jianzhioffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 * 一倍一倍往上乘就可以了，优化的空间在哪儿？
 * 可以一番一番往上乘
 */
public class Solution12 {
    public double Power(double base, int exponent) {
        if (Math.abs(base - 0.0) == 0){
            return 0.0;
        }
        double result = 1;
        if (exponent > 0) {
            while (exponent > 0) {
                result *= base;
                exponent--;
            }
        } else {
            while (exponent < 0) {
                result /= base;
                exponent++;
            }
        }

        return result;
    }

    public double Power1(double base, int exponent) {
        if (base == 0.0){
            return 0.0;
        }
        // 前置结果设为1.0，即当exponent=0 的时候，就是这个结果
        double result = 1.0d;
        // 获取指数的绝对值
        int e = exponent > 0 ? exponent : -exponent;
        // 根据指数大小，循环累乘
        for(int i = 1 ; i <= e; i ++){
            result *= base;
        }
        // 根据指数正负，返回结果
        return exponent > 0 ? result : 1 / result;
    }


    //折半乘
    public double Power3(double base, int exponent) {
        if (base == 0.0){
            return 0.0;
        }
        if (exponent == 0) {
            return 1;
        }
        boolean isNegative = exponent > 0;
        int e = isNegative ? exponent : -exponent;
        double result = base;
        while (e > 1) {
            result *= result;
            e /= 2;
        }
        if ((exponent & 1) != 0) {
            result *= base;
        }
        return isNegative ? result : 1/result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution12().Power3(2, -2));
    }
}
