package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
