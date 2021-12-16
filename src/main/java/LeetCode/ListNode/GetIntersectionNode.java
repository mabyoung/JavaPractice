package LeetCode.ListNode;

public class GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode cursorA = headA;
        ListNode cursorB = headB;
        if (lengthA >= lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                cursorA = cursorA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                cursorB = cursorB.next;
            }
        }
        while (cursorA != null) {
            if (cursorA == cursorB) {
                return cursorA;
            }
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int length = 1;
        ListNode cursor = head;
        while (cursor != null) {
            cursor = cursor.next;
            length++;
        }
        return length;
    }

}
