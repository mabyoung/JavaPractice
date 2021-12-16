package LeetCode.ListNode;

public class SplitListToParts {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode cursor = head;
        while (cursor != null) {
            length++;
            cursor = cursor.next;
        }
        int mod = length % k;
        int factor = length / k;
        int[] array = new int[k];
        for (int i = 0; i < mod; i++) {
            array[i] = factor + 1;
        }
        for (int i = mod; i < k; i++) {
            array[i] = factor;
        }
        ListNode[] result = new ListNode[k];
        cursor = head;
        for (int i = 0; i < array.length; i++) {
            ListNode tmp = new ListNode();
            ListNode tmpCursor = tmp;
            for (int j = 0; j < array[i]; j++) {
                ListNode copy = new ListNode();
                copy.val = cursor.val;
                tmpCursor.next = copy;
                tmpCursor = tmpCursor.next;
                cursor = cursor.next;
            }
            result[i] = tmp.next;
        }
        return result;
    }
}
