package tiba;

import org.apache.poi.ss.formula.functions.T;

/**
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替
 */
public class TreeMerge {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            TreeNode mergeNode = new TreeNode(t1.val + t2.val);
            mergeTrees(t1, t2, mergeNode);
            return mergeNode;
        }
    }

    public void mergeTrees(TreeNode t1, TreeNode t2, TreeNode mergeNode) {
        if (t1.left != null && t2.left != null) {
            TreeNode node = new TreeNode(t1.left.val + t2.left.val);
            mergeNode.left = node;
            mergeTrees(t1.left, t2.left, node);
        } else {
            mergeNode.left = t1.left != null ? t1.left : t2.left;
        }
        if (t1.right != null && t2.right != null) {
            TreeNode node = new TreeNode(t1.right.val + t2.right.val);
            mergeNode.right = node;
            mergeTrees(t1.right, t2.right, node);
        } else {
            mergeNode.right = t1.right != null ? t1.right : t2.right;
        }
    }
}
