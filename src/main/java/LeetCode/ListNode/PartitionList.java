package LeetCode.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given1->4->3->2->5->2and x = 3,
 * return1->2->2->4->3->5.
 * 思路：创建两条链表，分别链接小于x和大于x，最后合并两条链表
 */
public class PartitionList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode partion(ListNode head, int x){
        ListNode lessThanX = new ListNode(0);
        ListNode cursor1 = lessThanX;
        ListNode greaterThanX = new ListNode(0);
        ListNode cursor2 = greaterThanX;
        while(head != null){
            if (head.val < x){
                cursor1.next = head;
                cursor1 = cursor1.next;
            }else{
                cursor2.next = head;
                cursor2 = cursor2.next;
            }
            head = head.next;
        }
        cursor1.next = greaterThanX.next;
        cursor2.next = null;
        return lessThanX.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        PartitionList partitionList = new PartitionList();
        ListNode partion = partitionList.partion(node1, 3);
        System.out.println(partion);
    }
}
