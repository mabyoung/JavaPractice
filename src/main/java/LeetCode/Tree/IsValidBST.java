package LeetCode.Tree;

import java.util.HashMap;
import java.util.Map;

public class IsValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private Map<TreeNode, Long> maxMap = new HashMap<>();
    private Map<TreeNode, Long> minMap = new HashMap<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long leftMax = getMaxValue(root.left);
        if (leftMax >= root.val) {
            return false;
        }
        long rightMin = getMinValue(root.right);
        if (rightMin <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public long getMaxValue(TreeNode root) {
        if (maxMap.containsKey(root)) {
            return maxMap.get(root);
        }
        if (root == null) {
            return Long.MIN_VALUE;
        }
        long leftMax = getMaxValue(root.left);
        long rightMax = getMaxValue(root.right);
        long result = Math.max(root.val, Math.max(leftMax, rightMax));
        maxMap.put(root, result);
        return result;
    }

    public Long getMinValue(TreeNode root) {
        if (minMap.containsKey(root)) {
            return minMap.get(root);
        }
        if (root == null) {
            return Long.MAX_VALUE;
        }
        long leftMin = getMinValue(root.left);
        long rightMin = getMinValue(root.right);
        long result = Math.min(root.val, Math.min(leftMin, rightMin));
        minMap.put(root, result);
        return result;
    }
}
