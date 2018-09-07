package DataStructure.Graph;

import java.util.LinkedList;

public class BFS {
    static void bfs(AGraph graph, int v){
        int visit[] = new int[graph.n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(v);
        while(!queue.isEmpty()){
            Integer nextV = queue.pollFirst();
            if (visit[nextV] == 0){
                visit[nextV] = 1;
                System.out.println(graph.adjList[nextV].info);
                ArcNode index = graph.adjList[nextV].nextArc;
                while(index != null){
                    queue.addLast(index.no);
                    index = index.nextArc;
                }
            }
        }
    }

    public static void main(String[] args) {
        VNode[] vNodes = new VNode[5];
        vNodes[0] = new VNode(0, "v0", null);
        vNodes[1] = new VNode(1, "v1", null);
        vNodes[2] = new VNode(2, "v2", null);
        vNodes[3] = new VNode(3, "v3", null);
        vNodes[4] = new VNode(4, "v4", null);
        ArcNode arcNode1 = new ArcNode(1, null);
        ArcNode arcNode2 = new ArcNode(2, null);
        ArcNode arcNode3 = new ArcNode(3, null);
        ArcNode arcNode4 = new ArcNode(4, null);
        vNodes[0].nextArc = arcNode1;
        arcNode1.nextArc = arcNode2;
        vNodes[1].nextArc = arcNode3;
        arcNode3.nextArc = arcNode4;
        AGraph graph = new AGraph(vNodes, vNodes.length, 4);
        bfs(graph, 0);
    }
}
