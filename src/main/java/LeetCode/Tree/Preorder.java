package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Preorder {
    public class Node{
        public int val;
        public List<Node> children;
    }

    public List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preorderHelper(root);
        return list;
    }

    public void preorderHelper(Node root){
        if (root != null){
            list.add(root.val);
            for (Node child : root.children) {
                preorderHelper(child);
            }
        }
    }
}
