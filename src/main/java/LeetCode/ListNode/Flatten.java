package LeetCode.ListNode;

public class Flatten {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node cursor = head;
        while (cursor != null) {
            if (cursor.child != null) {
                Node child = flatten(cursor.child);
                Node tail = getTailNode(child);
                if (cursor.next != null){
                    cursor.next.prev = tail;
                    tail.next = cursor.next;
                }
                cursor.next = child;
                child.prev = cursor;
                cursor.child = null;
                cursor = tail;
            }
            cursor = cursor.next;
        }
        return head;
    }

    public Node getTailNode(Node node) {
        Node cursor = node;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        return cursor;
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        node1.child = node2;
        node2.child = node3;
        flatten.flatten(node1);
    }
}
