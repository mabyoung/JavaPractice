package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
    public class Node{
        int val;
        List<Node> children;
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        order(root);
        return list;
    }

    public void order(Node root){
        if (root != null){
            for (Node child : root.children) {
                order(child);
            }
            list.add(root.val);
        }
    }
}
