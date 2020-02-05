package jianzhioffer;

/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * ����˼·��
 * ������ʱ��ֱ�Ӳ��� stack1
 * ������ʱ���� stack2 ��Ϊ�գ����� stack2 ջ��Ԫ�أ���� stack2 Ϊ�գ��� stack1 �е�ȫ���������ջ��ջ stack2���ٵ��� stack2 ջ��Ԫ��
 */
import java.util.Stack;

public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }
}
