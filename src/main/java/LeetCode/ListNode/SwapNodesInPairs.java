package LeetCode.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given1->2->3->4, you should return the list as2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head){
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cursor = preHead;
        while(cursor.next != null && cursor.next.next != null){
            ListNode tmp = cursor.next.next;
            cursor.next.next = tmp.next;
            tmp.next = cursor.next;
            cursor.next = tmp;
            cursor = cursor.next.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode result = swapNodesInPairs.swapPairs(node1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
