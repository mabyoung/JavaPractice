package LeetCode.ListNode;

public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = head;
        ListNode cursor = preHead;
        int totalNodeNum = 0;
        while (cursor.next != null) {
            cursor = cursor.next;
            totalNodeNum++;
        }
        for (int i = 1; i < totalNodeNum - n % totalNodeNum; i++) {
            pre = pre.next;
        }
        cursor.next = preHead.next;
        preHead.next = pre.next;
        pre.next = null;
        return preHead.next;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode result = rotateList.rotateRight(node1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
