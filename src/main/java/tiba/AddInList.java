package tiba;

/**
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 */
public class AddInList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        ListNode node1 = reverse(head1);
        ListNode node2 = reverse(head2);
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int num1 = node1 != null ? node1.val : 0;
            int num2 = node2 != null ? node2.val : 0;
            int sum = num1 + num2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cursor.next = new ListNode(sum);
            cursor = cursor.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if (carry > 0) {
            cursor.next = new ListNode(carry);
        }
        return reverse(head.next);
    }

    public ListNode reverse(ListNode listNode) {
        ListNode head = new ListNode(0);
        ListNode cursor = listNode;
        while (cursor != null) {
            ListNode node = new ListNode(cursor.val);
            node.next = head.next;
            head.next = node;
            cursor = cursor.next;
        }
        return head.next;
    }
}
