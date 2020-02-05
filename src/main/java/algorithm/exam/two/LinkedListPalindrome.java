package algorithm.exam.two;

import java.util.Scanner;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = Integer.parseInt(scanner.nextLine());
        while(testCaseNum > 0) {
            String[] elements = scanner.nextLine().split(" ");
            String[] array = new String[elements.length-1];
            for(int i = 0;i < array.length;i++) {
                array[i] = elements[i+1];
            }
            LinkedList<String> list = new LinkedList<>();
            LinkedList<String> reversedList = new LinkedList<>();
            for (String a : array) {
                list.add(a);
                reversedList.add(a);
            }
            LinkedList.Node head = list.root.next;
//            System.out.println(list.toString(head));

            LinkedList.Node newHead = reversedList.reverseRecursive(reversedList.root.next);
//            System.out.println(list.toString(newHead));
            boolean isPalindrome = true;
            while (head != null && newHead != null) {
                if(!head.value.equals(newHead.value)) {
                    isPalindrome = false;
                }
                head = head.next;
                newHead = newHead.next;
            }
            System.out.println(isPalindrome);
            testCaseNum--;
        }
    }

    private void isPalindrome(int length, LinkedList<Integer> list) {
        //获得中间节点
        LinkedList.Node root = list.root;
        LinkedList.Node middle = list.root;
        for(int i = 0;i < length/2;i++) {
            middle = middle.next;
        }
        for(int i = 0;i < length/2;i++) {
            middle = middle.next;
        }
    }


    private static class LinkedList<E> {
        private Node root = new Node();
        private Node last;
        private int size;

        public LinkedList(){

        }

        public void add(E e) {
            if(null == e) return;
            Node next = new Node(e);
            if(size==0) {
                root.next = next;
                last = next;
                size++;
            }else{
                last.next = next;
                last = next;
                size++;
            }
        }

        public String toString(Node node) {
            Node tmp = new Node(node.next, node.value);
            StringBuilder builder = new StringBuilder();
            while(tmp != null) {
                builder.append(tmp.value + " ");
                tmp = tmp.next;
            }
            return builder.toString().trim();
        }

        private Node reverseRecursive(Node node) {
            if(node == null || node.next == null) return node;
            Node temp = node.next;
            Node newHead = reverseRecursive(node.next);
            temp.next = node;
            node.next = null;
            return newHead;
        }

        private Node reverseCiculation(Node node) {
            Node pre = null;
            Node next = null;
            while(node!=null) {
                next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            return pre;
        }

        private Node copyNode(Node node){
            return new Node(node.next, node.value);
        }

        private class Node{
            Node next;
            E value;

            Node() {
                next = null;
                value = null;
            }

            Node(E value) {
                next = null;
                this.value = value;
            }

            public Node(Node next, E value) {
                this.next = next;
                this.value = value;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public void setValue(E value) {
                this.value = value;
            }

        }
    }
}
