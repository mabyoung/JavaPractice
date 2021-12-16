package LeetCode.ListNode;

public class DeleteNode {
    public class ListNode{
        int val;
        ListNode next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
