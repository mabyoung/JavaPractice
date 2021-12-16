package LeetCode.ListNode;

/**
 * 2. 两数相加
 * 给定两个代表非负数的链表，数字在链表中是反向存储的（链表头结点处的数字是个位数，第二个结点上的数字是百位数...），
 * 求这个两个数的和，结果也用链表表示。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出： 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        ListNode result = new ListNode(0);
        ListNode resultCursor = result;
        int carry = 0;
        while (cursor1 != null || cursor2 != null) {
            int val1 = cursor1 == null ? 0 : cursor1.val;
            int val2 = cursor2 == null ? 0 : cursor2.val;
            int sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            resultCursor.next = new ListNode(sum);
            resultCursor = resultCursor.next;
            if (cursor1 != null) {
                cursor1 = cursor1.next;
            }
            if (cursor2 != null) {
                cursor2 = cursor2.next;
            }
        }
        if (carry != 0) {
            resultCursor.next = new ListNode(carry);
        }
        return result.next;
    }

}
