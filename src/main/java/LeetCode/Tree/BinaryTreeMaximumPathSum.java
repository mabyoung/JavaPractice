package LeetCode.Tree;

public class BinaryTreeMaximumPathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxValue;
    }

    public int getMaxPathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, getMaxPathSum(root.left));
        int right = Math.max(0, getMaxPathSum(root.right));
        maxValue = Math.max(maxValue, left+right+root.val);
        return root.val+Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int result = binaryTreeMaximumPathSum.maxPathSum(node1);
        System.out.println(result);
    }
}
