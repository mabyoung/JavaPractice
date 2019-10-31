package CrackingTheCodingInterview.ListNode;

/**
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 */
public class Palindrome {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode pHead) {
        ListNode reverseListNode = new ListNode(-1);
        ListNode cursor = pHead;
        while(cursor != null){
            ListNode tmp = new ListNode(cursor.val);
            tmp.next = reverseListNode.next;
            reverseListNode.next = tmp;
            cursor = cursor.next;
        }
        ListNode cursor1 = pHead;
        ListNode cursor2 = reverseListNode.next;
        while(cursor1 != null){
            if (cursor1.val != cursor2.val){
                return false;
            }
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }
        return true;
    }
}
