package LeetCode.Tree;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class RangeSumBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int leftValue = rangeSumBST(root.left, low, high);
        int rightValue = rangeSumBST(root.right, low, high);
        int myValue = 0;
        if (root.val >= low && root.val <= high) {
            myValue = root.val;
        }
        return leftValue + myValue + rightValue;
    }
}
