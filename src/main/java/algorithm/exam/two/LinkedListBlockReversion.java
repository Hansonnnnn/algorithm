package algorithm.exam.two;

import java.util.Arrays;
import java.util.Scanner;

public class LinkedListBlockReversion {
    public static void main(String[] args) {
        LinkedListBlockReversion linkedListBlockReversion = new LinkedListBlockReversion();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int window = Integer.valueOf(elements[elements.length-1]);
            String[] array = Arrays.copyOfRange(elements, 1, elements.length-1);
            if(array.length <= 0) return;

            linkedListBlockReversion.reverse(array, window);
//            System.out.println(Arrays.toString(array));
            for(int i = 0;i < array.length;i++) {
                if(i!=array.length-1) {
                    System.out.print(array[i] + " ");
                }else{
                    System.out.println(array[i]);
                }
            }
        }
    }

    private void reverse(String[] array, int window) {
        int times = array.length / window;
        for(int i = 0;i < times;i++) {
            for(int j = 0;j < window/2;j++) {
                String tmp = array[j+window*i];
                array[j+window*i] = array[window*(i+1)-1-j];
                array[window*(i+1)-1-j] = tmp;
            }
        }
    }

    private void reverseByLinkedList(String[] array, int window) {

    }

    private class Node{
        Node next;
        String value;

        public Node(Node next, String value) {
            this.next = next;
            this.value = value;
        }
    }
}
