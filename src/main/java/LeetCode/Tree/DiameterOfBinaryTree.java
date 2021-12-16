package LeetCode.Tree;

public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        preOrder(root);
        return max;
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            max = Math.max(max, getDiameter(root));
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public int getDiameter(TreeNode root) {
        return getDeep(root.left) + getDeep(root.right);
    }

    public int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDeep(root.left), getDeep(root.right)) + 1;
    }
}
