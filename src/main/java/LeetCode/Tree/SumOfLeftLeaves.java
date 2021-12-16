package LeetCode.Tree;

public class SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        int leftVal = root.left != null ? sumOfLeftLeaves(root.left) : 0;
        int rightVal = root.right != null ? sumOfLeftLeaves(root.right) : 0;
        return leftVal + rightVal;
    }
}
