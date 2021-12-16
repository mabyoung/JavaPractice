package LeetCode.ListNode;

public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preResult = new ListNode(-1);
        ListNode preL1 = new ListNode(-1);
        preL1.next = l1;
        ListNode preL2 = new ListNode(-1);
        preL2.next = l2;
        ListNode cursor = preResult;
        while (preL1.next != null && preL2.next != null) {
            if (preL1.next.val < preL2.next.val) {
                cursor.next = preL1.next;
                preL1.next = preL1.next.next;
            } else {
                cursor.next = preL2.next;
                preL2.next = preL2.next.next;
            }
            cursor = cursor.next;
        }
        if (preL1.next != null) {
            cursor.next = preL1.next;
        } else {
            cursor.next = preL2.next;
        }
        return preResult.next;
    }
}
