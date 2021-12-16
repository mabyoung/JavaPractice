package LeetCode.Tree;

public class GetMinimumDifference {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int lastValue = Integer.MIN_VALUE/2;
    public int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            min = Math.min(min, root.val - lastValue);
            lastValue = root.val;
            inorder(root.right);
        }
    }
}
