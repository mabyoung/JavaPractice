package LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public class ListNode {
        int val;
        ListNode next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode cursor = head;
        Set<ListNode> set = new HashSet<>();
        while (cursor != null) {
            if (set.contains(cursor)) {
                return true;
            } else {
                set.add(cursor);
            }
            cursor = cursor.next;
        }
        return false;
    }
}
