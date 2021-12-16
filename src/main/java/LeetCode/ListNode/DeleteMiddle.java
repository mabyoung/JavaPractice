package LeetCode.ListNode;

public class DeleteMiddle {
    public static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode cursor = head;
        while (cursor != null) {
            cursor = cursor.next;
            length++;
        }
        int middle = length / 2;
        ListNode preHead = new ListNode();
        preHead.next = head;
        cursor = preHead;
        while (middle-- > 0) {
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 2;
        DeleteMiddle deleteMiddle = new DeleteMiddle();
        deleteMiddle.deleteMiddle(head);
    }
}
