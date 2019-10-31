package CrackingTheCodingInterview.ListNode;

/**
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 */
public class Plus {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode result = new ListNode(-1);
        ListNode cursorA = a;
        ListNode cursorB = b;
        ListNode resultCursor = result;
        int carry = 0;
        while (cursorA != null || cursorB != null) {
            int valueA = cursorA == null ? 0 : cursorA.val;
            int valueB = cursorB == null ? 0 : cursorB.val;
            int sum = valueA + valueB + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            resultCursor.next = new ListNode(sum);
            resultCursor = resultCursor.next;
            if (cursorA != null) {
                cursorA = cursorA.next;
            }
            if (cursorB != null) {
                cursorB = cursorB.next;
            }
        }
        if (carry > 0) {
            resultCursor.next = new ListNode(carry);
        }
        return result.next;
    }
}
