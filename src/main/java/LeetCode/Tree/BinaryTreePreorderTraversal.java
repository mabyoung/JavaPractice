package LeetCode.Tree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 求给定的二叉树的前序遍历。
 * 备注；用递归来解这道题太没有新意了，可以给出迭代的解法么？
 */
public class BinaryTreePreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        ArrayList<Integer> result = binaryTreePreorderTraversal.preorderTraversal(node1);
        System.out.println(result);
    }
}
