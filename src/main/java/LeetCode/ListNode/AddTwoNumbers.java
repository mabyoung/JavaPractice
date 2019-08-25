package LeetCode.ListNode;

/**
 * 给定两个代表非负数的链表，数字在链表中是反向存储的（链表头结点处的数字是个位数，第二个结点上的数字是百位数...），
 * 求这个两个数的和，结果也用链表表示。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出： 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode cursor = preHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int tmp = val1 + val2 + carry;
            if (tmp >= 10) {
                tmp -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cursor.next = new ListNode(tmp);
            cursor = cursor.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0){
            cursor.next = new ListNode(carry);
        }
        return preHead.next;
    }

}
