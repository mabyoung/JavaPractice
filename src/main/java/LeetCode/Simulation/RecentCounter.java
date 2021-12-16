package LeetCode.Simulation;

import java.util.LinkedList;

public class RecentCounter {
    LinkedList<Integer> linkedList = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        linkedList.addLast(t);
        while (linkedList.getFirst() < t - 3000) {
            linkedList.removeFirst();
        }
        return linkedList.size();
    }
}
