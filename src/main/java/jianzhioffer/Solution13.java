package jianzhioffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution13 {
    public void reOrderArray(int [] array) {
        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> evenQueue = new LinkedList<>();

        for (int i = 0;i < array.length;i++) {
            if (isOdd(array[i])) {
                oddQueue.offer(array[i]);
            } else {
                evenQueue.offer(array[i]);
            }
        }

        int i = 0;
        while (!oddQueue.isEmpty()) {
            array[i++] = oddQueue.poll();
        }
        while (!evenQueue.isEmpty()) {
            array[i++] = evenQueue.poll();
        }
    }

    private boolean isOdd(int num) {
        return (num & 1) != 0;
    }

    public void reOrderArray1(int[] array) {
        int i = 0, j = i+1;
        while (j < array.length) {
            if (!isOdd(array[i])) {
                for (j = i+1;j < array.length;j++) {
                    if (isOdd(array[j])) break;
                }
                if (j == array.length) {
                    break;
                }
                int temp = array[j];
                for (int k = j;k > i;k--) {
                    array[k] = array[k-1];
                }
                array[i] = temp;
            }
            i++;
        }
    }
}
