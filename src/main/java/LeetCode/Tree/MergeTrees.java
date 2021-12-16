package LeetCode.Tree;

public class MergeTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int a = root1 == null ? 0 : root1.val;
        int b = root2 == null ? 0 : root2.val;
        TreeNode root = new TreeNode();
        root.val = a + b;
        TreeNode left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        TreeNode right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        root.left = left;
        root.right = right;
        return root;
    }

}
