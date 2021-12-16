package LeetCode.ListNode;

public class RemoveElements {
    public class ListNode {
        int val;
        ListNode next;
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode cur = root;
        while(cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return root.next;
    }
}
