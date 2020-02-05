package algorithm.exam.two;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] elements = scanner.nextLine().split(" ");
            int[] array = new int[elements.length];
            for (int i = 0;i < array.length;i++) {
                array[i] = Integer.valueOf(elements[i]);
            }
            mergeSort.mergeSortNonRecursive(array,array.length,0,array.length-1);
            for(int i = 0;i < array.length;i++) {
                if(i!=array.length-1) {
                    System.out.print(array[i] + " ");
                }else{
                    System.out.println(array[i]);
                }
            }
        }
    }

    private void mergeSortRecursive(int[] array, int length, int left, int right) {
        if(left >= right) return;
        int mid = (right - left) / 2 + left;
        mergeSortRecursive(array,mid-left+1,left,mid);
        mergeSortRecursive(array,right-mid,mid+1,right);
        merge(array,length,left,mid,mid+1,right);
    }

    /**
     * 这里不能像QuickSort一样使用Stack，因为Quick可以自顶向下进行排序
     * 而MergeSort只能自底向上进行归并，MergeSort的本质通过归并来实现排序
     * @param array
     * @param length
     * @param left
     * @param right
     */
    private void mergeSortNonRecursive(int[] array, int length, int left, int right) {
        int len = 1;
        while(len <= length) {
            for(int i = 0;i + len <= right ;i += len*2) {
                int low = i, mid = i + len - 1, high = i + 2 * len - 1;
                if(high > length - 1) {
                    high = length - 1;
                }
                merge(array, len*2, low, mid,mid+1, high);
            }
            len *= 2;
        }
    }

    private void merge(int[] array, int length, int arr1Left, int arr1Right, int arr2Left, int arr2Right) {
        int[] newArray = new int[length];
        int i = 0;
        int arr1Index = arr1Left;
        int arr2Index = arr2Left;
        while(arr1Index <= arr1Right && arr2Index <= arr2Right) {
            if(array[arr1Index] < array[arr2Index]) {
                newArray[i++] = array[arr1Index++];
            }else{
                newArray[i++] = array[arr2Index++];
            }
        }
        while(arr1Index <= arr1Right && i < length) {
            newArray[i++] = array[arr1Index++];
        }
        while(arr2Index <= arr2Right && i < length) {
            newArray[i++] = array[arr2Index++];
        }
        for(int j = arr1Left;j <= arr2Right;j++) {
            array[j] = newArray[j-arr1Left];
        }
    }

}
