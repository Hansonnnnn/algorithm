package jianzhioffer;

import java.util.ArrayList;

/**
 * ����һ�������������β��ͷ��˳�򷵻�һ��ArrayList��
 * �Ƚ���� - ���͵�ջ���ݽṹ
 * ����ջ���滻ʵ�� - �ݹ�
 */
public class Solution3 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
        }
    }
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
