package DataStructure.Graph;
import java.util.*;
/**
 * Created by rui on 2018/9/6.
 */
public class DFS {
    private static int visit[];
    static void dfs(AGraph graph, int v){
        if (visit[v] == 0){
            visit[v] = 1;
            System.out.println(graph.adjList[v].info);
            ArcNode node = graph.adjList[v].nextArc;
            while (node != null){
                dfs(graph, node.no);
                node = node.nextArc;
            }
        }
    }

    public static void main(String[] args) {
        int x=10;
        x+=x-=x-x;
        System.out.println(x);
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
        visit = new int[vNodes.length];
        dfs(graph, 0);
    }
}
