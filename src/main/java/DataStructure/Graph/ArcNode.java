package DataStructure.Graph;

/**
 * Created by rui on 2018/9/6.
 */
public class ArcNode {
    int adjvex;
    ArcNode nextArc;
    int info;
    public ArcNode(int adjvex, ArcNode nextArc){
        this.adjvex = adjvex;
        this.nextArc = nextArc;
    }
}
