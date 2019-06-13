package LeetCode.Tree;

import java.util.ArrayList;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *
 *     1
 *    / \
 *   2   3
 *
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 *
 * 思路：使用先序遍历，当遍历到叶子节点时计算当前和
 */
public class SumRootToLeafNumbers {
    private int result = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> current = new ArrayList<>();
        sumNumbersHelper(root, current);
        return result;
    }

    public void sumNumbersHelper(TreeNode root, ArrayList<Integer> current) {
        if (root == null){
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null) {
            int num = 0;
            for (Integer item : current) {
                num = item + 10 * num;
            }
            result += num;
        }
        if (root.left != null) {
            sumNumbersHelper(root.left, current);
            current.remove(current.size() - 1);
        }
        if (root.right != null) {
            sumNumbersHelper(root.right, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        System.out.println(sumRootToLeafNumbers.sumNumbers(node1));
    }
}
