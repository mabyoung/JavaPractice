package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DistanceK {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        boolean[][] edges = new boolean[501][501];
        buildEdges(root, edges);
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[501];
        queue.add(target.val);
        visited[target.val] = true;
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty() && count <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer now = queue.pollFirst();
                if (count == k) {
                    result.add(now);
                }
                for (int j = 0; j <= 500; j++) {
                    if (!visited[j] && edges[now][j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            count++;
        }
        return result;
    }

    public void buildEdges(TreeNode root, boolean[][] edges) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            edges[root.val][root.left.val] = true;
            edges[root.left.val][root.val] = true;
            buildEdges(root.left, edges);
        }
        if (root.right != null) {
            edges[root.val][root.right.val] = true;
            edges[root.right.val][root.val] = true;
            buildEdges(root.right, edges);
        }
    }
}
