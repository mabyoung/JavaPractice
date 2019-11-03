package CrackingTheCodingInterview.Tree;

/**
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
 * 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
public class Checker {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int minLimit, int maxLimit) {
        if (root == null) {
            return true;
        }
        if (root.val < minLimit || root.val > maxLimit) {
            return false;
        }
        return checkBST(root.left, minLimit, root.val) && checkBST(root.right, root.val, maxLimit);
    }
}
