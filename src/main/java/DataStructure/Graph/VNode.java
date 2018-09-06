package DataStructure.Graph;

/**
 * Created by rui on 2018/9/6.
 */
public class VNode {
    char data;
    ArcNode firstArc;
    int count;
    public VNode(ArcNode firstArc){
        this.firstArc = firstArc;
    }
}
