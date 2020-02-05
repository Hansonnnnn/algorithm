package algorithm.linkedList;

/**
 * https://www.cnblogs.com/keeya/p/9218352.html
 */
public class LinkedListReverse {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        LinkedListReverse linkedListReverse = new LinkedListReverse();
//        Node newHead = linkedListReverse.reverseRecursive(head);
        Node newHead = linkedListReverse.reverseCirculation(head);
        while(newHead != null) {
            System.out.print(newHead.value + " ");
            newHead = newHead.next;
        }
    }
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 递归：一次性直接探到底，拿到最后一个节点，一层层返回上去
     * 每次只需要考虑，第一个节点和下一个节点的逆序，之后的节点会由下一次递归来完成
     * @param head
     * @return
     */
    public Node reverseRecursive(Node head){
        if(head==null||head.next==null){return head;}
        Node temp = head.next;
        Node newHead = reverseRecursive(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public Node reverseCirculation(Node node) {
        Node pre = null;
        Node next = null;
        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
