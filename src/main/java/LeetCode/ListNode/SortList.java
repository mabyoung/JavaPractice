package LeetCode.ListNode;



public class SortList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode first, ListNode second) {
        ListNode preHead = new ListNode(0);
        ListNode cursor = preHead;
        while (first != null && second != null) {
            if (second.val < first.val) {
                cursor.next = second;
                cursor = cursor.next;
                second = second.next;
            } else {
                cursor.next = first;
                cursor = cursor.next;
                first = first.next;
            }
        }
        cursor.next = first == null ? second : first;
        return preHead.next;
    }


    public ListNode sortList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode mid = getMid(head);
            ListNode midNext = mid.next;
            mid.next = null;
            return merge(sortList(head), sortList(midNext));
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        SortList sortList = new SortList();
        ListNode listNode = sortList.sortList(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
