package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> valList = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        TreeNode preHead = new TreeNode();
        TreeNode cursor = preHead;
        for (Integer val : valList) {
            TreeNode node = new TreeNode();
            node.val = val;
            cursor.right = node;
            cursor = cursor.right;
        }
        return preHead.right;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            valList.add(root.val);
            inOrder(root.right);
        }
    }
}
