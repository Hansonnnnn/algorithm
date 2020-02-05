package algorithm.exam.finalExam.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 计数排序不是比较排序，排序的速度快于任何比较排序算法
 */
public class CountSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] eles = scanner.nextLine().split("\\s");
            int[] arr = new int[eles.length-1];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = Integer.parseInt(eles[i+1]);
            }
            arr = countSort(arr);
            for (int i = 0;i < arr.length;i++) {
                if (i==arr.length-1) {
                    System.out.print(arr[i]);
                }else {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[] countSort(int[] arr) {
        int[] count = new int[arr.length];
        for (int i = 0;i < arr.length;i++) {
            int cur = arr[i];
            for (int j = 0;j < arr.length;j++) {
                if (j != i) {
                    if (arr[j] <= cur) {
                        count[i]++;
                    }
                }
            }
        }
        int[] sortedArr = new int[arr.length];
        for (int i = 0;i < sortedArr.length;i++) {sortedArr[i] = -1;}
        for (int i = 0;i < count.length;i++) {
            if (sortedArr[count[i]] == arr[i]) {
                sortedArr[--count[i]] = arr[i];
            } else {
                sortedArr[count[i]] = arr[i];
            }
        }
        return sortedArr;
    }
}
