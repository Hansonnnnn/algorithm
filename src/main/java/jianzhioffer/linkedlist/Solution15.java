package jianzhioffer.linkedlist;

/**
 * ����һ��������ת��������������ı�ͷ��
 * 1 -> 2 -> 3 -> 4 -> 5
 * 2 -> 1 -> 3 -> 4 -> 5
 * 3 -> 2 -> 1 -> 4 -> 5
 */
public class Solution15 {


    //����ʵ��
    public ListNode ReverseList(ListNode head) {
        //���������ֻ��һ���ڵ㣬ֱ�ӷ���
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode next = head.next;
        dummy.next = head;

        while (next != null) {
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
            next = head.next;
        }
        return dummy.next;
    }

    public ListNode ReverseListRe(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = ReverseListRe(head.next);
        head.next.next = head;
        head.next = null; // ����ǰͷ�ڵ��������β��
        return newNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(new Solution15().ReverseList(node1).val);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
