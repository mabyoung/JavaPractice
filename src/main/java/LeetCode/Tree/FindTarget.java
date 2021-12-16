package LeetCode.Tree;

import java.util.HashMap;
import java.util.Map;

public class FindTarget {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    Map<Integer, Integer> map = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int target = k - key;
            if (key == target) {
                if (entry.getValue() >= 2) {
                    return true;
                }
            } else {
                if (map.containsKey(target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            map.merge(root.val, 1, Integer::sum);
            inOrder(root.left);
            inOrder(root.right);
        }
    }
}
