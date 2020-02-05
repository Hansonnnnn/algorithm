package jianzhioffer;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 *
 * ����ת�������ҵ���Сֵ
 *
 * �ؼ� r - 1 ����ѭ��ͣ����������
 */
public class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {return 0;}
        int l = 0, r = array.length-1;
        int mid = 0;
        while (l < (r - 1)) {
            mid = (l+r)/2;
            if (array[mid] > array[0]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (array[mid] < array[r]) {
            return array[mid];
        }
        return array[r];
    }
}
