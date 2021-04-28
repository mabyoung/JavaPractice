package CrackingTheCodingInterview.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Converter {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ListNode treeToList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;
        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.left;
        }
        while (!stack.isEmpty()) {
            cursor = stack.pop();
            list.add(cursor.val);
            cursor = cursor.right;
            while (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }
        }
        ListNode result = new ListNode(0);
        ListNode listCursor = result;
        for (Integer item : list) {
            ListNode tmp = new ListNode(item);
            listCursor.next = tmp;
            listCursor = tmp;
        }
        return result.next;
    }
}
