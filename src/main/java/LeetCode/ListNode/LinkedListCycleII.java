package LeetCode.ListNode;

/**
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 */
public class LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fastCursor = head.next.next;
        ListNode slowCursor = head.next;
        while (fastCursor != null && fastCursor.next != null && fastCursor != slowCursor) {
            fastCursor = fastCursor.next.next;
            slowCursor = slowCursor.next;
        }
        if (fastCursor != slowCursor) {
            return null;
        }
        ListNode beginCursor = head;
        while (beginCursor != slowCursor) {
            beginCursor = beginCursor.next;
            slowCursor = slowCursor.next;
        }
        return beginCursor;
    }
}
