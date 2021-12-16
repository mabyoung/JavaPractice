package LeetCode.ListNode;

public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = new ListNode();
            tmp.val = cur.val;
            tmp.next = result.next;
            result.next = tmp;
            cur = cur.next;
        }
        return result.next;
    }
}
