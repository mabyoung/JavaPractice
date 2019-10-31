package CrackingTheCodingInterview.ListNode;

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Partition {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        ListNode bigNodeList = new ListNode(-1);
        ListNode smallNodeList = new ListNode(-1);
        ListNode cursor = pHead, bigCursor = bigNodeList, smallCursor = smallNodeList;
        while (cursor != null) {
            if (cursor.val >= x) {
                bigCursor.next = cursor;
                bigCursor = bigCursor.next;
            } else {
                smallCursor.next = cursor;
                smallCursor = smallCursor.next;
            }
            cursor = cursor.next;
        }
        smallCursor.next = bigNodeList.next;
        bigCursor.next = null;
        return smallNodeList.next;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node0.next = node3;
        node3.next = node2;
        node2.next = node1;
        Partition partition = new Partition();
        ListNode result = partition.partition(node0, 2);
        System.out.println(result);
    }
}
