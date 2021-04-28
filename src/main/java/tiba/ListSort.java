package tiba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个无序单链表，实现单链表的排序(按升序排序)
 */
public class ListSort {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        while (preHead.next != null) {
            int max = 0;
            ListNode cursor = preHead;
            ListNode maxIndex = preHead;
            while (cursor.next != null) {
                if (cursor.next.val > max) {
                    max = cursor.next.val;
                    maxIndex = cursor;
                }
                cursor = cursor.next;
            }
            ListNode tmp = maxIndex.next;
            maxIndex.next = maxIndex.next.next;
            tmp.next = result.next;
            result.next = tmp;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListSort listSort = new ListSort();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
        node3.next = node2;
        node2.next = node4;
        node4.next = node5;
        ListNode listNode = listSort.sortInList(node1);
        System.out.println(listNode);
    }
}
