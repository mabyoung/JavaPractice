package tiba;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，请判断该链表是否为回文结构。
 */
public class Pail {
    public class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
