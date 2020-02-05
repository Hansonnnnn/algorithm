package jianzhioffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution8 {
    //递归
    public int JumpFloor(int target) {
        if (target <= 2) return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //dp - 最终的解是有前面累加起来的，如何缩小问题
    //找到递推式dp(i) = dp(i-2) + dp(i-1)
    //有了递推式，就成了斐波那契数列
    public int dpJump(int target) {
        if (target <= 2) return target;
        int i1 = 1, i2 = 2;
        int i3 = 0;
        while (target - 2 > 0) {
            i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
            target--;
        }
        return i3;
    }
}
