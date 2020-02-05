package algorithm.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseOrderPairNumber {
    private static int result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.valueOf(scanner.nextLine());
        String[] inputs = new String[caseNum];
        int index = 0;
        while(caseNum > 0) {
            scanner.nextLine();
            inputs[index++] = scanner.nextLine();
            caseNum--;
        }
        for (String str : inputs) {
            String[] arrayStr = str.split(" ");
            int[] array = new int[arrayStr.length];
            for (int i = 0;i < array.length;i++) {
                array[i] = Integer.valueOf(arrayStr[i]);
            }
            ReverseOrderPairNumber reverseOrderPairNumber = new ReverseOrderPairNumber();
            reverseOrderPairNumber.mergeSort(array, 0, array.length-1);
            System.out.println(result);
            result = 0;
        }
    }
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {return;}
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, mid+1, right);
    }

    private void merge(int[] arr, int arr1Left, int arr1Right, int arr2Left, int arr2Right) {
        int[] newArr = new int[arr.length];
        int arr1Index = arr1Left;
        int arr2Index = arr2Left;
        int i = 0;
        while (arr1Index <= arr1Right && arr2Index <= arr2Right) {
            if (arr[arr1Index] < arr[arr2Index]) {
                newArr[i++] = arr[arr1Index++];
            } else if (arr[arr1Index] > arr[arr2Index]){
                result += (arr1Right - arr1Index + 1);
                newArr[i++] = arr[arr2Index++];
            } else {
                newArr[i++] = arr[arr2Index++];
            }
        }
        while (arr1Index <= arr1Right) {
            newArr[i++] = arr[arr1Index++];
        }
        while (arr2Index <= arr2Right) {
            newArr[i++] = arr[arr2Index++];
        }
        for (int j = arr1Left;j <= arr2Right;j++) {
            arr[j] = newArr[j-arr1Left];
        }
    }
}
