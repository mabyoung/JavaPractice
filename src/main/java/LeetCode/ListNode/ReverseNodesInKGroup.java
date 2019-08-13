package LeetCode.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list:1->2->3->4->5
 * For k = 2, you should return:2->1->4->3->5
 * For k = 3, you should return:3->2->1->4->5
 */
public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode preLeft = preHead;
        ListNode left = head;
        ListNode right = preHead;
        ListNode afterRight;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (right.next == null) {
                    return preHead.next;
                }
                right = right.next;
            }
            afterRight = right.next;
            right.next = null;
            left = reverse(left);
            preLeft.next = left;
            while (left != null) {
                right = left;
                left = left.next;
            }
            right.next = afterRight;
            preLeft = right;
            left = preLeft.next;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode result = null;
        while (node != null) {
            ListNode tmp = node;
            node = node.next;
            tmp.next = result;
            result = tmp;
        }
        return result;
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
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode result = reverseNodesInKGroup.reverseKGroup(node1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
