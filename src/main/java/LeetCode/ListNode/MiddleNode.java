package LeetCode.ListNode;

public class MiddleNode {
    public class ListNode{
        int val;
        ListNode next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
