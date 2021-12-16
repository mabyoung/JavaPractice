package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            while (true) {
                if (stack.isEmpty()) {
                    break;
                }
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                    cur = pop.right;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        inorderTraversal.inorderTraversal(root);
    }
}
