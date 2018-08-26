package SwordOffer.Tree;

import java.util.ArrayList;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *      8
 *    /  \
 *   6   10
 *  / \  / \
 * 5  7 9 11
 * 镜像二叉树
 *      8
 *    /  \
 *   10   6
 *  / \  / \
 * 11 9 7  5
 */
public class Mirror {
    public static void mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode tmp = root .right;
        root.right = root.left;
        root.left = tmp;
        mirror(root.left);
        mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        mirror(root);
        ArrayList<Integer> integers = PrintFromTopToBottom.printFromTopToBottom(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
