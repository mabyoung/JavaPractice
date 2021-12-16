package LeetCode.ListNode;

public class DeleteDuplicates {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode();
        ListNode resultCursor = result;
        ListNode cursor = head.next;
        ListNode last = head;
        int num = 1;
        while (cursor != null) {
            if (cursor.val != last.val && num == 1) {
                ListNode tmp = new ListNode();
                tmp.val = last.val;
                resultCursor.next = tmp;
                resultCursor = resultCursor.next;
                last = cursor;
            } else if (cursor.val != last.val) {
                last = cursor;
                num =1;
            } else {
                num++;
            }
            cursor = cursor.next;
        }
        if (num == 1) {
            ListNode tmp = new ListNode();
            tmp.val = last.val;
            resultCursor.next = tmp;
        }
        return result.next;
    }
}
