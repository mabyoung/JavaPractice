package SwordOffer.Tree;

import static SwordOffer.Tree.ReConstructBinaryTree.reConstructBinaryTree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            if (isTree2InTree1(root1.left, root2.left) && isTree2InTree1(root1.right, root2.right)) {
                return true;
            }
        }
        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public static boolean isTree2InTree1(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null || tree1.val != tree2.val) {
            return false;
        }
        return isTree2InTree1(tree1.left, tree2.left) && isTree2InTree1(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        int[] pre1 = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in1 = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root1 = reConstructBinaryTree(pre1, in1);
        int[] pre2 = {3, 5, 6};
        int[] in2 = {5, 3, 6};
        TreeNode root2 = reConstructBinaryTree(pre2, in2);
        System.out.println(hasSubtree(root1, root2));
    }
}
