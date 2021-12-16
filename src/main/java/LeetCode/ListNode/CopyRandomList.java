package LeetCode.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node preHead = new Node(-1);
        preHead.next = head;
        Node cursor = preHead;
        while (cursor.next != null) {
            map.put(cursor.next, new Node(cursor.next.val));
            cursor = cursor.next;
        }
        cursor = preHead;
        while (cursor.next != null) {
            map.get(cursor.next).next = map.get(cursor.next.next);
            map.get(cursor.next).random = map.get(cursor.next.random);
            cursor = cursor.next;
        }
        return map.get(head);
    }

}
