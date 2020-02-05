package jianzhioffer.linkedlist;

/**
 * ����һ����������������е�����k�����
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
