package LeetCode.ListNode;

public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode curA = preHead;
        ListNode curB = preHead;
        while (n-- > 0) {
            curB = curB.next;
        }
        while (curB.next != null) {
            curA = curA.next;
            curB = curB.next;
        }
        curA.next = curA.next.next;
        return preHead.next;
    }

}
