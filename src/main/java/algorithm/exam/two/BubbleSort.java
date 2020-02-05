package algorithm.exam.two;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] unsortedArray = new int[elements.length-1];
            for (int i = 1;i < elements.length;i++) {
                unsortedArray[i-1] = Integer.valueOf(elements[i]);
            }
            bubbleSort.bubbleSort(unsortedArray);
        }
    }

    private void bubbleSort(int[] array) {
        int lastChangedIndex = array.length-1;
        int tmpLastChangedIndex = 0;
        for (int i = 0;i < array.length;i++) {
            for (int j = 0;j < lastChangedIndex;j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    tmpLastChangedIndex = j+1;
                }
            }
            lastChangedIndex = tmpLastChangedIndex;
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
