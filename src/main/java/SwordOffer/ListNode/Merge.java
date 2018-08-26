package SwordOffer.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode merge = new ListNode(0);
        merge.next = list1;
        ListNode pre = merge;
        while (list1 != null && list2 != null) {
            if (list2.val<list1.val){
                ListNode tmp = list2;
                list2 = list2.next;
                tmp.next = list1;
                pre.next = tmp;
                pre = pre.next;
            }else {
                list1 = list1.next;
                pre = pre.next;
            }
        }
        if (list2 != null){
            pre.next = list2;
        }
        return merge.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        list1.next = node2;
        node2.next = node4;
        list2.next = node3;
        node3.next = node5;
        ListNode merge = merge(list1, list2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
