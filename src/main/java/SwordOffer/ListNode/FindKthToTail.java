package SwordOffer.ListNode;

public class FindKthToTail {
    public static ListNode findKthToTail(ListNode head, int k) {
        ListNode index = head;
        for (int i = 0;i<k;i++){
            if (index == null){
                return null;
            }
            index = index.next;
        }
        ListNode find = head;
        while(index != null){
            index = index.next;
            find = find.next;
        }
        return find;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = null;
        for (int i = 1; i < 10; i++) {
            ListNode tmp = new ListNode(i);
            tmp.next = head.next;
            head.next = tmp;
        }
        System.out.println(findKthToTail(head, 10).val);
    }
}
