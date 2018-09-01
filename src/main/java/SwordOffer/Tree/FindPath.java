package SwordOffer.Tree;

import java.util.ArrayList;

import static SwordOffer.Tree.ReConstructBinaryTree.reConstructBinaryTree;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public static ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
    public static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        list.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            bigList.add(new ArrayList<>(list));
        }
        findPath(root.left, target - root.val);
        findPath(root.right, target - root.val);
        list.remove((Integer) root.val);
        return bigList;
    }

    public static void main(String[] args) {
        int[] pre = {10, 5, 4, 7, 12};
        int[] in = {4, 5, 7, 10, 12};
        TreeNode root = reConstructBinaryTree(pre, in);
        ArrayList<ArrayList<Integer>> path = findPath(root, 18);
        for (ArrayList<Integer> integers : path) {
            for (Integer integer : integers) {
                System.out.println(integer + " ");
            }
        }
    }
}
