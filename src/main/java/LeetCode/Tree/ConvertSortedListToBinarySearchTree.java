package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return buildBST(list, 0, list.size() - 1);
    }

    private TreeNode buildBST(List<Integer> list, int begin, int end) {
        if (begin > end) {
            return null;
        } else if (begin == end) {
            return new TreeNode(list.get(begin));
        }
        int mid = (begin + end + 1) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBST(list, begin, mid - 1);
        node.right = buildBST(list, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        TreeNode result = convertSortedListToBinarySearchTree.sortedListToBST(node1);
        System.out.println(result);
    }
}
