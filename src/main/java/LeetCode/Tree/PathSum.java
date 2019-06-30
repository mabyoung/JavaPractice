package LeetCode.Tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree andsum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 */
public class PathSum {
    private int currentSum = 0;
    private boolean flag = false;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        hasPathSumHelper(root, sum);
        return flag;
    }

    public void hasPathSumHelper(TreeNode root, int sum){
        if (root.left == null && root.right == null){
            if (currentSum+root.val == sum){
                flag  = true;
            }
            return;
        }
        currentSum += root.val;
        if (root.left != null){
            hasPathSumHelper(root.left, sum);
        }
        if (root.right != null){
            hasPathSumHelper(root.right, sum);
        }
        currentSum -= root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(node1, 3));
    }
}
