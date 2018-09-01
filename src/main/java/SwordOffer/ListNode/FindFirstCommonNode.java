package SwordOffer.ListNode;


/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0, length2 = 0;
        ListNode index1 = pHead1;
        ListNode index2 = pHead2;
        while(index1!=null){
            length1++;
            index1 = index1.next;
        }
        while (index2!=null){
            length2++;
            index2 = index2.next;
        }
        index1 = pHead1;
        index2 = pHead2;
        if (length1 < length2){
            for (int i= 0;i<length2-length1;i++){
                index2 = index2.next;
            }
        }else{
            for (int i= 0;i<length1-length2;i++){
                index1 = index1.next;
            }
        }
        while (index1!=null){
            if (index1 == index2){
                return index1;
            }
            index1 = index1.next;
            index2 = index2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node3;
        node3.next = node4;
        node2.next = node4;
        System.out.println(findFirstCommonNode(node1,node2).val);
    }
}
