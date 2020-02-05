package algorithm.sort;

import java.util.Arrays;

/**
 * 每次选出最小的，放在最边上
 * 时间复杂度为O（n^2）
 * 两层循环，每次选出未进行排序的部分的最小值
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
