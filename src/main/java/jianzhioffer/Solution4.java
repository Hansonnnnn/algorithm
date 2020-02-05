package jianzhioffer;

import java.util.Arrays;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * ǰ����������ڵ� - ������ - ������
 * ��������������� - ���ڵ� - ������
 * ��������������� - ������ - ���ڵ�
 * 1.����ǰ��������е�һ���ڵ� - ���ڵ�
 * 2.������������зָ������ 4��7��2 ��������5��3��8��6
 * 3.��2�еõ�������������������ǰ������������ó������ݹ�1��2
 * �ݹ���Ҫ��ֹͣ����
 * 2��4��7 ���ڵ� 2   ������4��7
 * 3��5��8��6 ���ڵ� 3   ������5    ������8��6
 * 4��7 ���ڵ� 4  ������ 7
 * 8��6 ���ڵ� 8  ������ 6
 */
public class Solution4 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int rootV = pre[0];
        for (int i = 0;i < in.length;i++) {
            if (in[i] == rootV) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        new Solution4().reConstructBinaryTree(new int[]{1,2,3,4,5,6,7}, new int[]{3,2,4,1,6,5,7});
    }
}
