package LeetCode.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cursor = preHead;
        for (int i = 1; i < m; i++) {
            cursor = cursor.next;
        }
        ListNode preM = cursor;
        cursor = cursor.next;
        preM.next = null;
        ListNode lastNode = cursor;
        ListNode preCursor;
        for (int i = m; i <= n; i++) {
            preCursor = cursor;
            cursor = cursor.next;
            preCursor.next = preM.next;
            preM.next = preCursor;
        }
        lastNode.next = cursor;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode listNode = reverseLinkedListII.reverseBetween(node1, 1, 2);
        System.out.println(listNode);
    }
}
