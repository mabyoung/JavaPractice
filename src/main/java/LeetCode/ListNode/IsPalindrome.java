package LeetCode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode cursor = head;
        List<Integer> list = new ArrayList<>();
        while (cursor != null) {
            list.add(cursor.val);
            cursor = cursor.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left++).equals(list.get(right--))) {
                return false;
            }
        }
        return true;
    }
}
