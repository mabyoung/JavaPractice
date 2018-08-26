package SwordOffer.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = result.next;
            result.next = node;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        for (int i = 10; i > 0; i--) {
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
        }
        ListNode index = reverseList(head);
        while (index != null) {
            System.out.println(index.val);
            index = index.next;
        }
    }
}
