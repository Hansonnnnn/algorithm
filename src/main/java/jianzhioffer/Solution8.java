package jianzhioffer;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 */
public class Solution8 {
    //�ݹ�
    public int JumpFloor(int target) {
        if (target <= 2) return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //dp - ���յĽ�����ǰ���ۼ������ģ������С����
    //�ҵ�����ʽdp(i) = dp(i-2) + dp(i-1)
    //���˵���ʽ���ͳ���쳲���������
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
