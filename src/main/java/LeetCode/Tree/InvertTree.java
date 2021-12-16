package LeetCode.Tree;

public class InvertTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
