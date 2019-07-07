package LeetCode.Tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
 */
public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode nodeX, TreeNode nodeY) {
        if (nodeX == null && nodeY == null) {
            return true;
        }
        if (nodeX == null || nodeY == null || nodeX.val != nodeY.val) {
            return false;
        }
        return check(nodeX.left, nodeY.right) && check(nodeX.right, nodeY.left);
    }
}
