package algorithm.sort;

import java.util.Arrays;

/**
 * ÿ��ѡ����С�ģ����������
 * ʱ�临�Ӷ�ΪO��n^2��
 * ����ѭ����ÿ��ѡ��δ��������Ĳ��ֵ���Сֵ
 */
public class SelectionSort {
    public static void main(String... args) {
        int[] arr = new int[]{-1,4,3,2,1};
        System.out.println(Arrays.toString(new SelectionSort().selectionSort(arr)));
    }

    public int[] selectionSort(int[] arr) {
        if (arr.length <= 0) {return null;}
        for (int i = 0;i < arr.length;i++) {
            for (int j = i+1;j < arr.length;j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
