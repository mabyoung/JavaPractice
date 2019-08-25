package LeetCode.ListNode;

/**
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 例如，
 * 给出的链表为:1->2->3->4->5, n= 2.↵↵   删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证n一定是合法的
 * 请尝试只用一步操作完成该功能
 * Given a linked list, remove the n th node from the end of list and return its head.
 * For example,
 * Given linked list:1->2->3->4->5, andn= 2.↵↵   After removing the second node from the end, the linked list becomes1->2->3->5.↵
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode first = preHead;
        ListNode second = preHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return preHead.next;
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
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode result = removeNthNodeFromEndOfList.removeNthFromEnd(node1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
