package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 */
public class LeafSimilar {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafList1 = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();
        getLeaf(root1, leafList1);
        getLeaf(root2, leafList2);
        if (leafList1.size() != leafList2.size()) {
            return false;
        }
        for (int i = 0; i < leafList1.size(); i++) {
            if (!leafList1.get(i).equals(leafList2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void getLeaf(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafList.add(root.val);
        }
        getLeaf(root.left, leafList);
        getLeaf(root.right, leafList);
    }
}
