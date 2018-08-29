package SwordOffer.Tree;

import java.util.ArrayList;

import static SwordOffer.Tree.ReConstructBinaryTree.reConstructBinaryTree;

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
