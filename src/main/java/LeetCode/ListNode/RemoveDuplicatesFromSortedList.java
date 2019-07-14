package LeetCode.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cursor = head;
        while(cursor != null && cursor.next != null){
            if (cursor.next.val == cursor.val){
                cursor.next = cursor.next.next;
            } else{
                cursor = cursor.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode listNode = removeDuplicatesFromSortedList.deleteDuplicates(node1);
        System.out.println(listNode);
    }
}
