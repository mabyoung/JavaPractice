package LeetCode.Tree;
/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest
 * path fromthe root node down to the nearest leaf node.
**/
 public class MinimumDepthOfBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public static int run(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null){
            return run(root.right)+1;
        }else if (root.right == null){
            return run(root.left)+1;
        }else {
            return Math.min(run(root.left), run(root.right))+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = null;
        node3.left = null;
        node3.right = null;
        node2.left = null;
        node2.right = node4;
        node4.left = null;
        node4.right = null;
        System.out.println(run(root));
    }
}
