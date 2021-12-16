package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left.isEmpty() && right.isEmpty()) {
            result.add(String.valueOf(root.val));
        }
        if (!left.isEmpty()) {
            for (int i = 0; i < left.size(); i++) {
                left.set(i, root.val + "->" + left.get(i));
            }
            result.addAll(left);
        }
        if (!right.isEmpty()) {
            for (int i = 0; i < right.size(); i++) {
                right.set(i, root.val + "->" + right.get(i));
            }
            result.addAll(right);
        }
        return result;
    }
}
