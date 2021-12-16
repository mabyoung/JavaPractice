package LeetCode.Simulation;

import java.util.*;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode() {

        }

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size = 0;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedNode target = cache.get(key);
        target.prev.next = target.next;
        target.next.prev = target.prev;
        target.next = head.next;
        head.next.prev = target;
        head.next = target;
        target.prev = head;
        return target.value;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            newNode.next = head.next;
            newNode.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
            size++;
            if (size > capacity) {
                cache.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                size--;
            }
        } else {
            DLinkedNode target = cache.get(key);
            target.value = value;
            target.prev.next = target.next;
            target.next.prev = target.prev;
            target.next = head.next;
            target.next.prev = target;
            head.next = target;
            target.prev = head;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
