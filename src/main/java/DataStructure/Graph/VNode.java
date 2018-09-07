package DataStructure.Graph;

public class VNode {
    int no;
    String info;
    ArcNode nextArc;
    public VNode(int no, String info, ArcNode nextArc){
        this.no = no;
        this.info = info;
        this.nextArc = nextArc;
    }
}
