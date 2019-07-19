package LeetCode.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead1 = new ListNode(0);
        ListNode preHead2 = new ListNode(0);
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        preHead1.next = l1;
        preHead2.next = l2;
        while (preHead1.next != null && preHead2.next != null) {
            if (preHead1.next.val < preHead2.next.val) {
                cursor.next = preHead1.next;
                preHead1.next = preHead1.next.next;
            } else {
                cursor.next = preHead2.next;
                preHead2.next = preHead2.next.next;
            }
            cursor = cursor.next;
        }
        if (preHead1.next != null) {
            cursor.next = preHead1.next;
        }
        if (preHead2.next != null) {
            cursor.next = preHead2.next;
        }
        return result.next;
    }
}
