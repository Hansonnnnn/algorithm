package jianzhioffer.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution17 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == root2.val) {
                if (subTreeSearch(node, root2)) {
                    return true;
                }
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return false;
    }

    private boolean subTreeSearch(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        if (!subTreeSearch(root1.left, root2.left)) {return false;}
        if (!subTreeSearch(root1.right, root2.right)) {return false;}
        return true;
    }

    public void dfsStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void dfsRecursive(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        dfsRecursive(root.left);
        dfsRecursive(root.right);
    }

    public void bfsStack(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node3.left = node5;
//        node3.right = node6;
        Solution17 solution17 = new Solution17();
//        solution17.dfsStack(node1);
//        System.out.println();
//        solution17.dfsRecursive(node1);
//        System.out.println();
//        solution17.bfsStack(node1);

        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        TreeNode root2 = new TreeNode(8);
        TreeNode node21 = new TreeNode(9);
        TreeNode node22 = new TreeNode(2);
        root2.left = node21;
        root2.right = node22;
        System.out.println(solution17.HasSubtree(root, root2));
    }
}
