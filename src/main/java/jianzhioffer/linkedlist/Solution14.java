package jianzhioffer.linkedlist;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class Solution14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode tail = head;
        while (k > 0) {
            if (tail == null) break;
            tail = tail.next;
            k--;
        }
        if (tail == null && k != 0) return null;
        while (tail!=null) {
            head = head.next;
            tail = tail.next;
        }
        return head;
    }
}
