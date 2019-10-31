package CrackingTheCodingInterview.ListNode;

/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 * 思路：把下一个节点值拷贝到当前节点，删除下一个节点
 */
public class Remove {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean removeNode(ListNode pNode) {
        if (pNode == null || pNode.next == null) {
            return false;
        }
        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return true;
    }
}
