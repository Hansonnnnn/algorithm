package algorithm.exam.two;

import java.util.Scanner;

/**
 * �Ż�������
 * 1�����ٽ���������ֱ�����ܲ��޸�����Ԫ��ʱ�ٽ��� - ������
 * 2��ÿ�ε��ڱ���ߵ��������ź���ģ�û��Ҫһ��һ�����ҵ����Բ����λ��
 * https://blog.csdn.net/qq_28081081/article/details/80594386
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] unsortedArray = new int[elements.length-1];
            for (int i = 0;i < unsortedArray.length;i++) {
                unsortedArray[i] = Integer.valueOf(elements[i+1]);
            }
            insertSort.insertSort2(unsortedArray);
        }
    }
    private void insertSort(int[] array) {
        for (int i = 1;i < array.length;i++) {
            for (int j = 0;j < i;j++) {
                if (array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        printArray(array);
    }

    private void insertSort2(int[] array) {
        for(int i = 1;i < array.length;i++) {
            int temp = array[i];
            int j = 0;
            for(j=i;j > 0 && array[j-1] > temp;j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
        printArray(array);
    }

    private void printArray(int[] array) {
        for (int i = 0;i < array.length;i++) {
            if (i == array.length-1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }
}
