package LeetCode.ListNode;

public class GetKthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = 0;
        ListNode cursor = head;
        while (cursor != null) {
            length++;
            cursor = cursor.next;
        }
        cursor = head;
        for (int i = 0; i < length - k; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }
}
