package LeetCode.Tree;

public class FindTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMyTilt(root) + findTilt(root.left) + findTilt(root.right);
    }

    public int getMyTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(getSum(root.left) - getSum(root.right));
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSum(root.left) + getSum(root.right) + root.val;
    }
}
