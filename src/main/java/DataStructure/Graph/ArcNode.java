package DataStructure.Graph;

/**
 * Created by rui on 2018/9/6.
 */
public class ArcNode {
    int no;
    ArcNode nextArc;
    public ArcNode(int no, ArcNode nextArc){
        this.no = no;
        this.nextArc = nextArc;
    }
}
