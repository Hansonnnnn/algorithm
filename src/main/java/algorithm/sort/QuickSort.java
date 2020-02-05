package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    /**
     * 这一个quick sort还没有理解快速排序的精髓
     * @param arr
     * @param left
     * @param right
     */
    public void quicksort(int[] arr, int left, int right){
        //递归要有最后的终止条件
        if(left > right) return;
        int i = left;
        int j = right;
        //先要取出mark
        int mark = arr[i];
        while(i != j){
            //一定要j先移动
            while(arr[i] <= mark && i < j){i++;}
            while(arr[j] >= mark && i < j){j--;}

            if(i < j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //出了循环，i==j
        arr[left] = arr[i];
        arr[i] = mark;

        quicksort(arr, left,i-1);
        quicksort(arr, i+1,right);
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            //如果加上等号快排是稳定的，不加的话，游标会在等于的地方停下来，紧接着就会交换
            while (i < j && arr[j] > pivot) {j--;}
            while (i < j && arr[i] < pivot) {i++;}
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //因为j先移动，所以对于偶数个元素的数组，如，4，5，3，1-------1和5交换，j首先会移动到下标为2的地方，i也会移动到2的地方，所以换i换j都可以
        //但是对于奇数个元素的数组，如4，5，6，3，1------i和j分别指向6和3，交换之后，ij分别加一个和减一个，j指向3，i指向6，不能交换i和pivot
        arr[left] = arr[j];
        arr[j] = pivot;

        quickSort(arr, left, i-1);
        quickSort(arr,i, right);
    }

    public static void main(String[] args) {
        int[] arr = {6,3,2,4,1};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(arr));
//        quickSort.quicksort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        quickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
