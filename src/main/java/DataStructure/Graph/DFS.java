package DataStructure.Graph;

/**
 * Created by rui on 2018/9/6.
 */
public class DFS {
    private static int visit[];
    static void dfs(AGraph graph, int v){
        if (visit[v] == 0){
            visit[v] = 1;
            System.out.println(graph.adjList[v].firstArc.adjvex);
            ArcNode firstArc = graph.adjList[v].firstArc;
            while (firstArc.nextArc != null){
                dfs(graph, firstArc.nextArc.adjvex);
                firstArc = firstArc.nextArc;
            }
        }
    }

    public static void main(String[] args) {
        VNode[] vNodes = new VNode[4];
        for (int i=0;i<vNodes.length;i++){
            ArcNode arcNode = new ArcNode(i, null);
            VNode node = new VNode(arcNode);
            vNodes[i] = node;
        }
        vNodes[0].firstArc.nextArc = new ArcNode(1, new ArcNode(3, null));
        vNodes[1].firstArc.nextArc = new ArcNode(2, new ArcNode(3, null));
        AGraph graph = new AGraph(vNodes, vNodes.length-1, 4);
        visit = new int[vNodes.length];
        dfs(graph, 0);
    }
}
