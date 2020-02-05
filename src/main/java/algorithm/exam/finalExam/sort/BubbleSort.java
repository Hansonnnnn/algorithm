package algorithm.exam.finalExam.sort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] eles = scanner.nextLine().split("\\s");
            int[] arr = new int[eles.length-1];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = Integer.parseInt(eles[i+1]);
            }
            bubbleSort(arr);
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

    private static void bubbleSort(int[] arr) {
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0;j < arr.length-i-1;j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static void bubbleSort1(int[] arr) {
        boolean changed = false;
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0;j < arr.length-i-1;j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }

    private static void bubbleSort2(int[] arr) {
        boolean changed = false;
        int sortedBorder = arr.length;
        int lastChangedIndex = sortedBorder;
        for (int i = 0;i < sortedBorder;i++) {
            for (int j = 0;j < arr.length-i-1;j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    changed = true;
                    lastChangedIndex = j;
                }
            }
            if (!changed) {
                break;
            }
            sortedBorder = lastChangedIndex;
        }
    }
}
