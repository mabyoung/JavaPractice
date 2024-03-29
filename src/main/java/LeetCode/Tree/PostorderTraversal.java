package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
