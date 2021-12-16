package LeetCode.Simulation;

import java.util.LinkedList;

public class MyHashMap {
    public class Map {
        int key;
        int value;
    }

    private static final int BASE = 10000;
    private LinkedList<Map>[] lists;

    public MyHashMap() {
        lists = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        LinkedList<Map> linkedList = lists[key % BASE];
        int index = getIndex(key);
        if (index == -1) {
            Map map = new Map();
            map.key = key;
            map.value = value;
            linkedList.add(map);
        } else {
            linkedList.get(index).value = value;
        }
    }

    public int get(int key) {
        LinkedList<Map> linkedList = lists[key % BASE];
        int index = getIndex(key);
        if (index == -1) {
            return -1;
        }
        return linkedList.get(index).value;
    }

    public int getIndex(int key) {
        LinkedList<Map> linkedList = lists[key % BASE];
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).key == key) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int key) {
        LinkedList<Map> linkedList = lists[key % BASE];
        int index = getIndex(key);
        if (index != -1) {
            linkedList.remove(index);
        }
    }
}
