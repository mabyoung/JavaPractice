package LeetCode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseBetween {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            list.add(cursor.val);
            cursor = cursor.next;
        }
        left--;
        right--;
        while (left < right) {
            Integer tmp = list.get(left);
            list.set(left++, list.get(right));
            list.set(right--, tmp);
        }
        ListNode result = new ListNode();
        cursor = result;
        for (Integer item : list) {
            ListNode tmp = new ListNode();
            tmp.val = item;
            cursor.next = tmp;
            cursor = cursor.next;
        }
        return result.next;
    }
}
