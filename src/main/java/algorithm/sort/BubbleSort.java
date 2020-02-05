package algorithm.sort;

import java.util.Arrays;

/**
 * ð������ÿ�ζ����԰�һ����Сֵ�������ֵ��ð����
 * һ����ȥ�������Ƚϣ��������ŵ����ұߣ���N��
 * �������Ż��ĵط������ǿ��Ƿ��Ѿ��ȶ�������
 *
 * ����Ҫ����ÿ�ζ������ų�һ�����Ļ�����С�ģ����Եڶ���ѭ����ʱ�򣬻�ÿ�μ�Сһ��
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
        boolean exchanged = false; //��Ҫ�����־λ���������ѭ������Ϊ�����Ƿ��ź������ڲ�ѭ������
        int sortedBorder = arr.length-1; //ʲôʱ����ܸ�������ź����ֵ�ı߽� -- ��ÿһ��ð����
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

    //�����߼� + �߽����
    //��һ��ѭ���У�ÿһ��ֻ�ܰ�һ����len-1���Ԫ���ҳ���
    //�ڶ���ѭ���У�ÿ�������бȽ�
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
