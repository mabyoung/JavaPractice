package LeetCode.Tree;

import java.util.ArrayList;

/**
 * 给定一个值n,请生成所有的存储值1...n.的二叉搜索树（BST）的结构
 * 例如：
 * 给定n=3，你的程序应该给出下面五种不同的二叉搜索树（BST）
 */
public class UniqueBinarySearchTreesII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return createTrees(1, n);
    }

    public ArrayList<TreeNode> createTrees(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (low > high) {
            result.add(null);
            return result;
        } else if (low == high) {
            result.add(new TreeNode(low));
            return result;
        }
        for (int i = low; i <= high; i++) {
            ArrayList<TreeNode> leftTrees = createTrees(low, i - 1);
            ArrayList<TreeNode> rightTrees = createTrees(i + 1, high);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTrees.get(j);
                    node.right = rightTrees.get(k);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        ArrayList<TreeNode> treeNodes = uniqueBinarySearchTreesII.generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
        }
    }
}
