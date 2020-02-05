package jianzhioffer;

import java.util.Stack;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Solution7 {
    //recursive
    //递归的时间复杂度怎么算 - 递归计算语句是一棵高度为n的二叉树
    //所以为O(2^n)
    //https://wmjtxt.github.io/2018/12/26/three_method_of_fibonacci/
    public int Fibonacci(int n) {
        if (n <= 1) return n;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    //递归会计算大量重复数据
    public int FibRecursiveOptimization(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n];
        arr[0] = arr[1] = 1;
        for (int i = 2;i < n;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }

    //每次其实只用到两个数
    public int FibRO2(int n) {
        if (n <= 1) return n;
        int n1 = 1, n2 = 1;
        int result = n2;
        for (int i = 2;i < n;i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }


    //stack implementation
    public int Fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        int n1 = 0, n2 = 0;
        while (n - 2 > 0) {
            n2 = stack.pop();
            n1 = stack.pop();
            stack.push(n2);
            stack.push(n1+n2);
            n--;
        }
        return stack.pop();
    }
}
