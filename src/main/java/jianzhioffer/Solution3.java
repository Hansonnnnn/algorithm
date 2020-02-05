package jianzhioffer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 先进后出 - 典型的栈数据结构
 * 或者栈的替换实现 - 递归
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
