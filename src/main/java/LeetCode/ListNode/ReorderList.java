package LeetCode.ListNode;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode getMid(ListNode head){
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode preHead = new ListNode(0);
        while(head != null){
            ListNode next = head.next;
            head.next = preHead.next;
            preHead.next = head;
            head = next;
        }
        return preHead.next;
    }

    public void reorderList(ListNode head) {
        if (head != null){
            ListNode mid = getMid(head);
            ListNode midNext = mid.next;
            mid.next = null;
            ListNode second = reverse(midNext);
            ListNode cursor = head;
            while(cursor != null && second != null){
                ListNode next = second.next;
                second.next = cursor.next;
                cursor.next = second;
                cursor = cursor.next.next;
                second = next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node1);
        while(node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
