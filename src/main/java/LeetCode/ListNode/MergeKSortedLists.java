package LeetCode.ListNode;

import java.util.ArrayList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode[] preHeads = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            preHeads[i] = new ListNode(0);
            preHeads[i].next = lists.get(i);
        }
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        int min;
        while ((min = isAllListsEmpty(preHeads)) != -1) {
            for (int i = 0; i < lists.size(); i++) {
                if (preHeads[i].next != null && preHeads[i].next.val < preHeads[min].next.val) {
                    min = i;
                }
            }
            cursor.next = preHeads[min].next;
            preHeads[min].next = preHeads[min].next.next;
            cursor = cursor.next;
        }
        return result.next;
    }

    private int isAllListsEmpty(ListNode[] preHeads) {
        for (int i = 0; i < preHeads.length; i++) {
            if (preHeads[i].next != null) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node3.next = node4;
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node3);
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode result = mergeKSortedLists.mergeKLists(list);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
