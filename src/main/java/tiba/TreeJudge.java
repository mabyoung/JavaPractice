package tiba;

import java.util.LinkedList;

/**
 * 给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
 */
public class TreeJudge {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt(TreeNode root) {
        boolean[] result = new boolean[2];
        result[0] = isSearchTree(root);
        result[1] = isCompleteTree(root);
        return result;
    }

    public boolean isSearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.left.val > root.val) || (root.right != null && root.right.val < root.val)) {
            return false;
        }
        if ((root.left != null && getMaxVal(root.left) > root.val) || (root.right != null && getMinVal(root.right) < root.val)) {
            return false;
        }
        if (!isSearchTree(root.left)) {
            return false;
        }
        return isSearchTree(root.right);
    }

    public int getMaxVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Math.max(root.val, getMaxVal(root.left)), getMaxVal(root.right));
    }

    public int getMinVal(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(root.val, getMinVal(root.left)), getMinVal(root.right));
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean theEnd = false;
        while (!queue.isEmpty()) {
            TreeNode first = queue.removeFirst();
            if (theEnd && first.left != null) {
                return false;
            } else if (!theEnd && first.left != null) {
                queue.addLast(first.left);
            } else if (!theEnd) {
                theEnd = true;
            }
            if (theEnd && first.right != null) {
                return false;
            } else if (!theEnd && first.right != null) {
                queue.addLast(first.right);
            } else if (!theEnd) {
                theEnd = true;
            }
        }
        return true;
    }

}
