package LeetCode.Tree;

public class SearchBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftResult = searchBST(root.left, val);
        TreeNode rightResult = searchBST(root.right, val);
        if (leftResult != null) {
            return leftResult;
        }
        return rightResult;
    }
}
