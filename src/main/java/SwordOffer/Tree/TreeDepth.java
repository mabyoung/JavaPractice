package SwordOffer.Tree;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    public static int treeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1+ Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        node1.right = node2;
        System.out.println(treeDepth(root));
    }
}
