package LeetCode.Tree;

public class HasPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, targetSum);
    }

    public boolean hasPathSumHelper(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        if (root.left != null && hasPathSumHelper(root.left, targetSum - root.val)) {
            return true;
        }
        if (root.right != null && hasPathSumHelper(root.right, targetSum - root.val)) {
            return true;
        }
        return false;
    }
}
