package jianzhioffer;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 *
 * ��֤base��exponent��ͬʱΪ0
 *
 * һ��һ�����ϳ˾Ϳ����ˣ��Ż��Ŀռ����Ķ���
 * ����һ��һ�����ϳ�
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
        // ǰ�ý����Ϊ1.0������exponent=0 ��ʱ�򣬾���������
        double result = 1.0d;
        // ��ȡָ���ľ���ֵ
        int e = exponent > 0 ? exponent : -exponent;
        // ����ָ����С��ѭ���۳�
        for(int i = 1 ; i <= e; i ++){
            result *= base;
        }
        // ����ָ�����������ؽ��
        return exponent > 0 ? result : 1 / result;
    }


    //�۰��
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
