package LeetCode.ListNode;

public class SwapPairs {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode cursor = preHead;
        while (cursor.next != null && cursor.next.next != null) {
            ListNode next = cursor.next;
            ListNode nnext = cursor.next.next;
            ListNode nnnext = cursor.next.next.next;
            cursor.next = nnext;
            nnext.next = next;
            next.next = nnnext;
            cursor = next;
        }
        return preHead.next;
    }
}
