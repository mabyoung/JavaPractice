package LeetCode.Tree;

public class MinDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepthHelper(root);
    }

    public int minDepthHelper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE / 2;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.min(minDepthHelper(root.left), minDepthHelper(root.right));
    }
}
