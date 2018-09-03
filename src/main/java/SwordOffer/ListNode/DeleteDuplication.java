package SwordOffer.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode first = new ListNode(0);
        first.next = pHead;
        ListNode pre = first;
        while (pHead != null && pHead.next != null) {
            if (pHead.next.val == pHead.val) {
                int val = pHead.val;
                while (pHead != null && pHead.val == val) {
                    pHead = pHead.next;
                }
                pre.next = pHead;
            } else {
                pre = pre.next;
                pHead = pHead.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode node1 = new ListNode(2);
        pHead.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        node5.next = node6;
        ListNode listNode = deleteDuplication(pHead);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
