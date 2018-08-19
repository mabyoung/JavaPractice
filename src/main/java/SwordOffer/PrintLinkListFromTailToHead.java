package SwordOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rui on 2018/8/18.
 */
public class PrintLinkListFromTailToHead {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ArrayList<Integer> result = printListFromTailToHead(head);
        System.out.println(result);
    }
}
