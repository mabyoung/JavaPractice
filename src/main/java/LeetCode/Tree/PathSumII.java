package LeetCode.Tree;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree andsum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {
    private int currentSum = 0;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> curentPath = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        pathSumHelper(root, sum, curentPath, result);
        return result;
    }

    public void pathSumHelper(TreeNode root, int sum, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> result) {
        if (root.left == null && root.right == null){
            if (currentSum + root.val == sum){
                currentPath.add(root.val);
                result.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size()-1);
            }
            return;
        }
        currentPath.add(root.val);
        currentSum += root.val;
        if (root.left != null){
            pathSumHelper(root.left, sum, currentPath, result);
        }
        if (root.right != null){
            pathSumHelper(root.right, sum, currentPath, result);
        }
        currentPath.remove(currentPath.size()-1);
        currentSum -= root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        PathSumII pathSumII = new PathSumII();
        ArrayList<ArrayList<Integer>> arrayLists = pathSumII.pathSum(node1, 22);
        System.out.println(arrayLists);
    }
}
