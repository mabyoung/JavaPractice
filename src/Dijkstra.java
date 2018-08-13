public class Dijkstra {
    public static final int maxSize = 1000;
    public static final int INF = Integer.MAX_VALUE/2;
    public static void dijkstra(MGraph g, int v0, int path[], int dist[]){
        int[]vset = new int[maxSize];
        int v=0;
        for (int i = 1; i <= g.n; i++){
            dist[i] = g.edges[v0][i];
            vset[i] = 0;
            if (dist[i] < INF){
                path[i] = v0;
            } else {
                path[i] = -1;
            }
        }
        vset[v0] = 1;path[v0] = -1;
        for (int i = 1; i < g.n; i++){
            int min = INF;
            for (int j = 1; j <= g.n; j++){
                if (vset[j] ==  0 && dist[j] < min){
                    min = dist[j];
                    v = j;
                }
            }
            vset[v] = 1;
            for (int j = 1; j <= g.n; j++){
                if (vset[j] == 0 && dist[v]+g.edges[v][j] <dist[j]){
                    dist[j] = dist[v] + g.edges[v][j];
                    path[j] = v;
                }
            }
        }
    }

    public static void main(String[] args) {
        MGraph mGraph = new MGraph();
        mGraph.n = 8;
        mGraph.e = 12;
        VertextType[] vertextTypes = new VertextType[mGraph.n+1];
        for (int i = 1; i <= mGraph.n; i++){
            vertextTypes[i] = new VertextType();
            vertextTypes[i].no = i+1;
        }
        mGraph.vex = vertextTypes;
        mGraph.edges = new int[][]{{},{0,0,3,2,INF,1,INF,INF,INF},{0,3,0,INF,2,INF,INF,2,INF},{0,2,INF,0,1,INF,4,INF,INF},
                {0,INF,2,1,0,INF,INF,2,INF},{0,1,INF,INF,INF,0,4,INF,3},{0,INF,INF,4,INF,4,0,2,2},
                {0,INF,2,INF,2,INF,2,0,INF},{0,INF,INF,INF,INF,3,2,INF,0}};
        int path[] = new int[mGraph.n+1];
        int dist[] = new int[mGraph.n+1];
        dijkstra(mGraph, 1, path, dist);
        for (int item : dist) {
            System.out.println(item);
        }
    }
}
