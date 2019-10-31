package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 */
public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class TreeNodeWithLevel {
        TreeNode treeNode;
        int level;

        TreeNodeWithLevel(TreeNode node, int lev) {
            this.treeNode = node;
            this.level = lev;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(root, 1));
        int lastLevel = 1;
        ArrayList<Integer> current = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNodeWithLevel treeNodeWithLevel = queue.pollFirst();
            if (treeNodeWithLevel.level != lastLevel) {
                result.add(new ArrayList<>(current));
                current = new ArrayList<>();
            }
            current.add(treeNodeWithLevel.treeNode.val);
            if (treeNodeWithLevel.treeNode.left != null){
                queue.addLast(new TreeNodeWithLevel(treeNodeWithLevel.treeNode.left, treeNodeWithLevel.level+1));
            }
            if (treeNodeWithLevel.treeNode.right != null){
                queue.addLast(new TreeNodeWithLevel(treeNodeWithLevel.treeNode.right, treeNodeWithLevel.level+1));
            }
            lastLevel = treeNodeWithLevel.level;
        }
        result.add(current);
        return result;
    }
}
