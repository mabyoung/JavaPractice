package CrackingTheCodingInterview.Tree;

import java.util.LinkedList;

/**
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 * 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
public class TreeLevel {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNodeWithDep {
        TreeNode treeNode;
        int dep;

        TreeNodeWithDep(TreeNode treeNode, int dep) {
            this.treeNode = treeNode;
            this.dep = dep;
        }
    }

    public ListNode getTreeLevel(TreeNode root, int dep) {
        LinkedList<TreeNodeWithDep> queue = new LinkedList<>();
        queue.add(new TreeNodeWithDep(root, 1));
        ListNode result = new ListNode(-1);
        ListNode cursor = result;
        while (!queue.isEmpty()) {
            TreeNodeWithDep first = queue.getFirst();
            queue.removeFirst();
            if (first.dep == dep) {
                cursor.next = new ListNode(first.treeNode.val);
                cursor = cursor.next;
            } else {
                if (first.treeNode.left != null) {
                    queue.addLast(new TreeNodeWithDep(first.treeNode.left, first.dep + 1));
                }
                if (first.treeNode.right != null) {
                    queue.addLast(new TreeNodeWithDep(first.treeNode.right, first.dep + 1));
                }
            }
        }
        return result.next;
    }
}
