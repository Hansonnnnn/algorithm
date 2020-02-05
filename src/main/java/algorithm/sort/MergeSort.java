package algorithm.sort;

import java.util.Arrays;

/**
 * �鲢�����˼�룺�ֶ���֮
 * �Զ����£�������ֳ�һ��һ����Ԫ�أ�����ÿ�������ŵĵ�λ���кϲ�
 * ��Ҫע���
 * 1.merge��ʱ���������ԭ������ʲô��ϵ�����������������ڵ�λ�ϲ������ģ���ôҲ����������������λ���ҽ�֮��ķ�Χ
 *
 * tips��������java����һ�����󣬴��뷽��
 * https://blog.51cto.com/14234228/2435751
 *
 * ʱ�临�Ӷȣ���logn�㣬ÿ����Ҫ���й鲢��Ԫ��Ϊn������ʱ�临�Ӷ�ΪO��nlogn��
 * �ռ临�Ӷȣ�O��n����ÿ�ο��ٵĿռ䲻�����
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
        //�ϲ��õ���һ����С�����ԭ������Ĺ�ϵ
        for (int j = arr1Left;j <= arr2Right;j++) {
            arr[j] = newArr[j-arr1Left];
        }
    }
}
