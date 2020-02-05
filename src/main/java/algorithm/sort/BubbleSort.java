package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序每次都可以把一个最小值或者最大值给冒出来
 * 一趟下去，两两比较，将最大的排到最右边，跑N趟
 * 可以有优化的地方，就是看是否已经稳定下来了
 *
 * 最重要的是每次都可以排出一个最大的或者最小的，所以第二层循环的时候，会每次减小一个
 *
 * https://blog.csdn.net/wubingju93123/article/details/81215984
 */
public class BubbleSort {
    public static void main (String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr1 = {1,5,3,2,4};
        System.out.println(Arrays.toString(bubbleSort.retryBubbleSortFinal(arr1)));
//        System.out.println(Arrays.toString(bubbleSort.bubbleSort(arr1)));
        int[] arr2 = {5,4,3,2,1};
        System.out.println(Arrays.toString(bubbleSort.retryBubbleSortFinal(arr1)));
//        System.out.println(Arrays.toString(bubbleSort.bubbleSort(arr2)));
//        System.out.println(Arrays.toString(bubbleSort.bubbleSortA1(arr2)));
    }
    int[] retryBubbleSort(int[] arr) {
        if(arr.length <= 0) return null;
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    int[] retryBubbleSortAdvanced(int[] arr) {
        if(arr.length <= 0) return null;
        boolean exchanged = false;
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    exchanged = true;
                }
            }
            if (!exchanged) {break;}
        }
        return arr;
    }

    int[] retryBubbleSortFinal(int[] arr) {
        if(arr.length <= 0) return null;
        boolean exchanged = false; //需要这个标志位来跳出外层循环，因为决定是否排好序是内层循环决定
        int sortedBorder = arr.length-1; //什么时候才能更新这个排好序的值的边界 -- 在每一次冒泡完
        int lastUnsortedIndex = 0;
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0; j < sortedBorder; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                    exchanged = true;
                    lastUnsortedIndex = j;
                }
            }
            if (!exchanged) break;
            sortedBorder = lastUnsortedIndex;
        }
        return arr;
    }

    //基本逻辑 + 边界控制
    //第一层循环中，每一次只能把一个第len-1大的元素找出来
    //第二层循环中，每两个进行比较
//    int[] bubbleSort(int[] arr) {
//        for (int i = 0;i < arr.length;i++) {
//            for (int j = 0;j < arr.length - i -1;j++) {
//                if (arr[j] > arr[j+1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        return arr;
//    }


//    int[] bubbleSortA1(int[] arr) {
//        boolean exchanged = false;
//        for (int i = 0;i < arr.length;i++) {
//            for (int j = 0;j < arr.length - i -1;j++) {
//                if (arr[j] > arr[j+1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//
//                    exchanged = true;
//                }
//            }
//            if (!exchanged) break;
//        }
//        return arr;
//    }
}
