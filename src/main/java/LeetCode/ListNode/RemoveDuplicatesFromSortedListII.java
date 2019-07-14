package LeetCode.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given1->2->3->3->4->4->5, return1->2->5.
 * Given1->1->1->2->3, return2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cursor = preHead;
        while (cursor.next != null && cursor.next.next != null) {
            if (cursor.next.val == cursor.next.next.val){
                int val = cursor.next.val;
                while(cursor.next != null && cursor.next.val == val){
                    cursor.next = cursor.next.next;
                }
            } else{
                cursor = cursor.next;
            }
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        ListNode listNode = removeDuplicatesFromSortedListII.deleteDuplicates(node1);
        System.out.println(listNode);
    }
}
