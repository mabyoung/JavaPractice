package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 后序非递归遍历
 */
public class BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if ((peek.left == null && peek.right == null) || (pre != null && peek.right == null && pre == peek.left)
                    || (pre != null && pre == peek.right)) {
                result.add(peek.val);
                stack.pop();
                pre = peek;
            } else {
                if (peek.right != null) {
                    stack.push(peek.right);
                }
                if (peek.left != null) {
                    stack.push(peek.left);
                }
            }
        }
        return result;
    }
}
