package LeetCode.Tree;

public class ValidateBinarySearchTree {
    private int lastVal = Integer.MIN_VALUE;
    private boolean flag = true;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return flag;
    }

    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        isValidBST(root.left);
        if (root.val <= lastVal){
            flag = false;
        }
        lastVal = root.val;
        isValidBST(root.right);
    }
}
