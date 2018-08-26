package SwordOffer.ListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：
 * 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
 * 2、遍历链表，A1->random = A->random->next;
 * 3、将链表拆分成原链表和复制后的链表
 */
public class Clone {
    public static RandomListNode findRandomNode(RandomListNode pHead, RandomListNode nHead, RandomListNode targetNode) {
        RandomListNode pIndex = pHead;
        RandomListNode nIndex = nHead;
        while (pIndex != targetNode) {
            pIndex = pIndex.next;
            nIndex = nIndex.next;
        }
        return nIndex;
    }

    public static RandomListNode solution1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode nHead = new RandomListNode(pHead.label);
        RandomListNode pIndex = pHead;
        RandomListNode nIndex = nHead;
        while (pIndex.next != null) {
            RandomListNode tmp = new RandomListNode(pIndex.next.label);
            nIndex.next = tmp;
            nIndex = tmp;
            pIndex = pIndex.next;
        }
        pIndex = pHead;
        nIndex = nHead;
        while (pIndex != null) {
            nIndex.random = findRandomNode(pHead, nHead, pIndex.random);
            pIndex = pIndex.next;
            nIndex = nIndex.next;
        }
        return nHead;
    }

    public static RandomListNode solution2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode pIndex = pHead;
        while (pIndex != null) {
            RandomListNode tmp = new RandomListNode(pIndex.label);
            tmp.next = pIndex.next;
            pIndex.next = tmp;
            pIndex = tmp.next;
        }
        pIndex = pHead;
        while (pIndex != null) {
            pIndex.next.random = pIndex.random == null ? null : pIndex.random.next;
            pIndex = pIndex.next.next;
        }
        RandomListNode nHead = pHead.next;
        RandomListNode nIndex = nHead;
        pIndex = pHead;
        while (pIndex != null) {
            pIndex.next = nIndex.next;
            nIndex.next = nIndex.next == null ? null : nIndex.next.next;
            pIndex = pIndex.next;
            nIndex = nIndex.next;
        }
        return nHead;
    }

    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(0);
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        pHead.next = node1;
        pHead.random = node1;
        node1.next = node2;
        node1.random = node2;
        pHead = solution2(pHead);
        while (pHead != null) {
            System.out.println(pHead.label);
            pHead = pHead.next;
        }
    }
}
