package algorithm.exam.two;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class QuickSort {
    private void quickSortRecursive(int[] array, int left, int right) {
        if(left >= right) return;
        int pivot = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i<j && array[j]>pivot) {j--;}
            while (i<j && array[i]<=pivot) {i++;}
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        array[left] = array[j];
        array[j] = pivot;

        quickSortRecursive(array, left, i-1);
        quickSortRecursive(array,j+1,right);
    }

    private void quickSortNonRecursive(int[] array, int left, int right) {
        if(left >= right) return;
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            int tmpRight = stack.pop();
            int tmpLeft = stack.pop();
            if(tmpLeft >= tmpRight) continue;
            int j = tmpRight;
            int i = tmpLeft;
            int pivot = array[i];
            while (i < j) {
                while (i<j && array[j]>pivot) {j--;}
                while (i<j && array[i]<=pivot) {i++;}
                if(i < j) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            array[tmpLeft] = array[j];
            array[j] = pivot;

            stack.push(tmpLeft);
            stack.push(i-1);

            stack.push(j+1);
            stack.push(tmpRight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] elements = scanner.nextLine().split(" ");
            int[] array = new int[elements.length];
            for (int i = 0;i < array.length;i++) {
                array[i] = Integer.valueOf(elements[i]);
            }
            new QuickSort().quickSortNonRecursive(array,0,array.length-1);
            for(int i = 0;i < array.length;i++) {
                if(i!=array.length-1) {
                    System.out.print(array[i] + " ");
                }else{
                    System.out.println(array[i]);
                }
            }
        }

    }
}
