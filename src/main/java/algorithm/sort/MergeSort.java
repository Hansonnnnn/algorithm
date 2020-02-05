package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序的思想：分而治之
 * 自顶向下：将数组分成一个一个的元素，最后会每两个挨着的单位进行合并
 * 需要注意的
 * 1.merge的时候新数组和原数组是什么关系：新数组是两个相邻单位合并出来的，那么也就是这相邻两个单位左右界之间的范围
 *
 * tips：数组在java中是一个对象，传入方法
 * https://blog.51cto.com/14234228/2435751
 *
 * 时间复杂度：有logn层，每层需要进行归并的元素为n，所以时间复杂度为O（nlogn）
 * 空间复杂度：O（n），每次开辟的空间不会叠加
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{0,-1,7,6,5,1,2,3,4,-1};
        mergeSort.mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {return;}
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr,mid + 1, right);
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
        //合并好的这一部分小数组和原来数组的关系
        for (int j = arr1Left;j <= arr2Right;j++) {
            arr[j] = newArr[j-arr1Left];
        }
    }
}
