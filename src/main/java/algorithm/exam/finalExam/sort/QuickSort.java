package algorithm.exam.finalExam.sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 核心点：1）选取基准元素 2）如何移动元素：挖坑法、指针交换法
 * https://blog.csdn.net/libaineu2004/article/details/82253412
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] eles = scanner.nextLine().split("\\s");
            int[] arr = new int[eles.length-1];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = Integer.parseInt(eles[i+1]);
            }
            quickSortNonRec(arr, 0, arr.length-1);
            for (int i = 0;i < arr.length;i++) {
                if (i==arr.length-1) {
                    System.out.print(arr[i]);
                }else {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
//        int[] arr1 = new int[]{5,4,3,3,2,1};
//        quickSort(arr1, 0, arr1.length-1);
//        System.out.println(Arrays.toString(arr1));
//        int[] arr2 = new int[]{5,4,3,3,2,1};
//        quickSortNonRec(arr2, 0, arr2.length-1);
//        System.out.println(Arrays.toString(arr2));
    }
    //递归实现：核心步骤：1.指针左移和右移 2.交换 3.指针重合然后和pivot交换  4.得到最后停下来的index分两部分递归
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] > pivot) {j--;}
            while (i < j && arr[i] <= pivot) {i++;}
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //交换ij重合处和pivot
        arr[left] = arr[i];
        arr[i] = pivot;

        quickSort(arr, left, i-1);
        quickSort(arr, i+1, right);
    }

    private static void quickSortNonRec(int[] arr, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            int iRight = stack.pop();
            int iLeft = stack.pop();
            if (iLeft >= iRight) continue;
            int pivot = arr[iLeft];
            int i = iLeft;
            int j = iRight;
            while (i < j) {
                while (i < j && arr[j] > pivot) {j--;}
                while (i < j && arr[i] <= pivot) {i++;}
                if (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            //交换ij重合处和pivot
            arr[iLeft] = arr[i];
            arr[i] = pivot;

            stack.push(iLeft);
            stack.push(i-1);
            stack.push(i+1);
            stack.push(iRight);
        }

    }
}
