package algorithm.exam.finalExam.sort;

import java.util.Scanner;

/**
 * 插入排序可以分为三种：直接插入排序、二分插入排序、希尔排序
 * 本质上就是拿着一个值插入到已经排好序的数组中
 */
public class InsertSort {
    //直接插入排序
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while (caseNum-->0) {
            String[] eles = scanner.nextLine().split("\\s");
            int[] arr = new int[eles.length-1];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = Integer.parseInt(eles[i+1]);
            }
            insertSort(arr);
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

    /**
     * 直接插入排序：需要从后往前比，只要小就交换
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            for (int j = i;j > 0;j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

}
