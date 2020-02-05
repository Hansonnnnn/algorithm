package jianzhioffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * n&(n-1) 每做一次这样的运算，会把n这个数的二进制表示的最右边的一个1变为0
 * 能做几次这样的运算，那么就表示有多少个1
 */
public class Solution11 {
    public int NumberOf1(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n-1);
            result++;
        }
        return result;
    }
}
