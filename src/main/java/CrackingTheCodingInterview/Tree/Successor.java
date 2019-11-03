package CrackingTheCodingInterview.Tree;

import java.util.Stack;

public class Successor {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int findSucc(TreeNode root, int p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;
        Integer lastVal = null;
        while (cursor != null || !stack.isEmpty()) {
            if (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            } else {
                TreeNode pop = stack.pop();
                if (lastVal != null && lastVal == p) {
                    return pop.val;
                }
                lastVal = pop.val;
                cursor = pop.right;
            }
        }
        return -1;
    }
}
