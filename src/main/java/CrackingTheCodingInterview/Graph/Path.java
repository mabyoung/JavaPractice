package CrackingTheCodingInterview.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 *
 * 给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b(请不要在意数据类型，图是有向图),请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */
public class Path {
    public class UndirectedGraphNode {
        int label = 0;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        List<UndirectedGraphNode> visitList = new ArrayList<>();
        queue.addLast(a);
        while (!queue.isEmpty()) {
            UndirectedGraphNode currentNode = queue.getFirst();
            queue.removeFirst();
            if (currentNode == b){
                return true;
            }
            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                if (!visitList.contains(neighbor)) {
                    queue.addLast(neighbor);
                    visitList.add(neighbor);
                }
            }
        }
        return false;
    }
}
