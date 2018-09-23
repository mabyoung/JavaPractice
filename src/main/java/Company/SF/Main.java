package Company.SF;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node list1 = new Node(-1), pre = list1;
        for (int i = 0; i < n; i++) {
            Node node = new Node(scanner.nextInt());
            pre.next = node;
            pre = node;
        }
        list1 = list1.next;
        Node list2 = new Node(-1);
        pre = list2;
        for (int i = 0; i < n; i++) {
            Node node = new Node(scanner.nextInt());
            pre.next = node;
            pre = node;
        }
        list2 = list2.next;
        int result = 0;
        while (list1 != null) {
            pre = list2;
            Node now = list2;
            int index = 0;
            while (now.data != list1.data) {
                if (index != 0) {
                    pre = pre.next;
                }
                now = now.next;
                index++;
            }
            result += index;
            list1 = list1.next;
            if (index != 0) {
                pre.next = now.next;
            } else {
                list2 = list2.next;
            }
        }
        System.out.println(result);
    }
}

