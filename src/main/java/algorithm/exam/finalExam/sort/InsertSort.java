package algorithm.exam.finalExam.sort;

import java.util.Scanner;

/**
 * ����������Է�Ϊ���֣�ֱ�Ӳ������򡢶��ֲ�������ϣ������
 * �����Ͼ�������һ��ֵ���뵽�Ѿ��ź����������
 */
public class InsertSort {
    //ֱ�Ӳ�������
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while (caseNum-->0) {
            String[] eles = scanner.nextLine().split("\\s");
            int[] arr = new int[eles.length-1];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = Integer.parseInt(eles[i+1]);
            }
            insertSort(arr);
            for (int i = 0;i < arr.length;i++) {
                if (i==arr.length-1) {
                    System.out.print(arr[i]);
                }else {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * ֱ�Ӳ���������Ҫ�Ӻ���ǰ�ȣ�ֻҪС�ͽ���
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            for (int j = i;j > 0;j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

}
