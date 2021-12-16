package LeetCode.Tree;

public class MinDiffInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private Integer lastValue;
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (lastValue != null) {
                minDiff = Math.min(minDiff, root.val - lastValue);
            }
            lastValue = root.val;
            inOrder(root.right);
        }
    }
}
