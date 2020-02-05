package algorithm.exam.finalExam.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * 归并排序
 * 核心两个步骤：分组、归并
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,2,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (right - left) / 2 + left;
        Stack<Integer> stack = new Stack<>();
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, mid+1, right);
    }

    private static void merge(int[] arr, int arr1Left, int arr1Right, int arr2Left, int arr2Right) {
        int[] newArr = new int[arr.length];
        int arr1Index = arr1Left;
        int arr2Index = arr2Left;
        int newArrIndex = 0;
        while (arr1Index <= arr1Right && arr2Index <= arr2Right) {
            if (arr[arr1Index] < arr[arr2Index]) {
                newArr[newArrIndex++] = arr[arr1Index++];
            } else {
                newArr[newArrIndex++] = arr[arr2Index++];
            }
        }
        while (arr1Index <= arr1Right) {
            newArr[newArrIndex++] = arr[arr1Index++];
        }
        while (arr2Index <= arr2Right) {
            newArr[newArrIndex++] = arr[arr2Index++];
        }
        for (int j = arr1Left;j <= arr2Right;j++) {
            arr[j] = newArr[j-arr1Left];
        }
    }
}
