package jianzhioffer;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 *
 * n&(n-1) ÿ��һ�����������㣬���n������Ķ����Ʊ�ʾ�����ұߵ�һ��1��Ϊ0
 * �����������������㣬��ô�ͱ�ʾ�ж��ٸ�1
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
