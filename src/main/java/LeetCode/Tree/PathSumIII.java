package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            if (now.left != null) {
                queue.add(now.left);
            }
            if (now.right != null) {
                queue.add(now.right);
            }
            result += pathSumHelper(now, targetSum);
        }
        return result;
    }

    public int pathSumHelper(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            return 1 + pathSumHelper(root.left, 0) + pathSumHelper(root.right, 0);
        } else {
            return pathSumHelper(root.left, targetSum - root.val) + pathSumHelper(root.right, targetSum - root.val);
        }
    }


}
