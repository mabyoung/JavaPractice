package LeetCode.Tree;

import java.util.List;

public class MaxDepth {
    public class Node {
        int val;
        List<Node> children;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            int childDepth = maxDepth(child);
            max = Math.max(max, childDepth);
        }
        return 1 + max;
    }
}
