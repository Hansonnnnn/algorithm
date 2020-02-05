package jianzhioffer;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 */
public class Solution9 {
    //�ܲ�����dp�����ܲ��ܰ�������С���ҵ�����ʽ
    //dp(i) = dp(i-1) + dp(i-2) + .... + dp(2) + dp(1)
    public int JumpFloorII(int target) {
        if (target <= 2) { return target; }
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        int index = 2;
        while (target - 2 > 0) {
            for (int i = 0;i < index;i++) {
                dp[index]+=dp[i];
            }
            dp[index]++;
            index++;
            target--;
        }
        return dp[index-1];
    }

    //��֪ f(n)=f(n-1)+f(n-2)+����f(1)
    //f(n-1)=f(n-2)+����f(1)
    //��ʽ�����f(n)=2f(n-1)
    public int Jump2(int target) {
        if (target <= 2) { return target; }
        int i2 = 2;
        int i3 = 0;
        while (target - 2 > 0) {
            i3 = i2 * 2;
            i2 = i3;
            target--;
        }
        return i3;
    }
}
