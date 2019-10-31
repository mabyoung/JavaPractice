package LeetCode.ListNode;

/**
 * 判断给定的链表中是否有环
 * 扩展：
 * 你能给出不利用额外空间的解法么？
 */
public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastCursor = head.next.next;
        ListNode slowCursor = head.next;
        while (fastCursor != null && fastCursor.next != null && fastCursor != slowCursor) {
            fastCursor = fastCursor.next.next;
            slowCursor = slowCursor.next;
        }
        return fastCursor == slowCursor;
    }
}
