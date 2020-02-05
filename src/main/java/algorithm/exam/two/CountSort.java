package algorithm.exam.two;

import java.util.Scanner;

/**
 * 将每个元素转换为新数组的下标，
 */
public class CountSort {
    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] unsortedArray = new int[elements.length-1];
            for (int i = 1;i < elements.length;i++) {
                unsortedArray[i-1] = Integer.valueOf(elements[i]);
            }
            countSort.countSort(unsortedArray);
        }
    }

    private void countSort(int[] array) {
        //找到最大值和最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0;i < array.length;i++) {
            if (array[i] < min) {min = array[i];}
            if (array[i] > max) {max = array[i];}
        }
        int[] times = new int[max-min+1];
        for (int i = 0;i < array.length;i++) {
            times[array[i]-min]++;
        }
        for (int i = 0;i < times.length;i++) {
            if(times[i] == 0) continue;
            for (int j = 0;j  < times[i];j++) {
                if (i == times.length-1 && j == times[i]-1) {
                    System.out.println(i+min);
                } else {
                    System.out.print(i+min + " ");
                }
            }
        }
    }
}
