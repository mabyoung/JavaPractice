package DataStructure.Graph;

/**
 * Created by rui on 2018/9/6.
 */
public class AGraph {
    VNode[] adjList;
    int n,e;
    public AGraph(VNode[] adjList, int n , int e){
        this.adjList = adjList;
        this.n = n;
        this.e = e;
    }
}
