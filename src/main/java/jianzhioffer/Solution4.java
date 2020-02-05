package jianzhioffer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 前序遍历：根节点 - 左子树 - 右子树
 * 中序遍历：左子树 - 根节点 - 右子树
 * 后序遍历：左子树 - 右子树 - 根节点
 * 1.根据前序遍历序列第一个节点 - 根节点
 * 2.在中序遍历序列分割：左子树 4，7，2 右子树：5，3，8，6
 * 3.对2中得到的左子树和右子树在前序遍历序列中拿出来，递归1和2
 * 递归需要有停止条件
 * 2，4，7 根节点 2   左子树4，7
 * 3，5，8，6 根节点 3   左子树5    右子树8，6
 * 4，7 根节点 4  左子树 7
 * 8，6 根节点 8  右子树 6
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
