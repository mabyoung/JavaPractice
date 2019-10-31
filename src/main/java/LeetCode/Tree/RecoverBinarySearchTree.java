package LeetCode.Tree;

public class RecoverBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode wrongNode1;
    private TreeNode wrongNode2;
    private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        int tmp = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = tmp;
    }

    public void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        if (wrongNode1 == null && root.val < preNode.val) {
            wrongNode1 = preNode;
        }
        if (wrongNode1 != null && root.val < preNode.val) {
            wrongNode2 = root;
        }
        preNode = root;
        inOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        recoverBinarySearchTree.recoverTree(node1);
    }
}