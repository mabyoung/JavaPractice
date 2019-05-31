package LeetCode.ListNode;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }
        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        RandomListNode result = head.next;
        while (p != null) {
            RandomListNode copy = p.next;
            p.next = p.next.next;
            copy.next = copy.next == null ? null : copy.next.next;
            p = p.next;
        }
        return result;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        node1.next = null;
        node1.random = null;
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        copyListWithRandomPointer.copyRandomList(node1);
    }
}
