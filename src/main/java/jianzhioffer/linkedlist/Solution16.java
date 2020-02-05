package jianzhioffer.linkedlist;

/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */
public class Solution16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode newHead = new ListNode(-1);
        ListNode p3 = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p3.next = list1;
                list1 = list1.next;
            } else {
                p3.next = list2;
                list2 = list2.next;
            }
            p3 = p3.next;
        }
        while (list1 != null) {
            p3.next = list1;
            list1 = list1.next;
            p3 = p3.next;
        }
        while (list2 != null) {
            p3.next = list2;
            list2 = list2.next;
            p3 = p3.next;
        }
        return newHead.next;
    }
}
