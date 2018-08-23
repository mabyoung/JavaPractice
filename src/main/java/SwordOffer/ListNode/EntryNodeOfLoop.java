package SwordOffer.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode find = pHead;
        while (find != slow) {
            find = find.next;
            slow = slow.next;
        }
        return find;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(3);
        pHead.next.next.next = new ListNode(4);
        pHead.next.next.next.next = pHead.next.next;
        ListNode result = entryNodeOfLoop(pHead);
        System.out.println(result.val);
    }
}
