package LeetCode.Graph;

import java.util.*;

public class CloneGraph {
    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cursorOld = queue.poll();
            UndirectedGraphNode cursorNew;
            if (map.containsKey(cursorOld.label)) {
                cursorNew = map.get(cursorOld.label);
            } else {
                cursorNew = new UndirectedGraphNode(cursorOld.label);
                map.put(cursorOld.label, cursorNew);
            }
            for (UndirectedGraphNode neighbor : cursorOld.neighbors) {
                if (map.containsKey(neighbor.label)) {
                    cursorNew.neighbors.add(map.get(neighbor.label));
                } else {
                    UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, tmp);
                    cursorNew.neighbors.add(tmp);
                    queue.offer(neighbor);
                }
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(0);
        node1.neighbors.add(node1);
        node1.neighbors.add(node1);
        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.cloneGraph(node1);
    }
}
