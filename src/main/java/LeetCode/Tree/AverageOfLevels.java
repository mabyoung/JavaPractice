package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                if (now.left != null){
                    queue.add(now.left);
                }
                if (now.right != null){
                    queue.add(now.right);
                }
                sum += now.val;
            }
            result.add(sum/size);
        }
        return result;
    }
}
