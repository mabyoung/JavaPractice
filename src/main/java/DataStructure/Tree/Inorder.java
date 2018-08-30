package DataStructure.Tree;

import SwordOffer.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

import static SwordOffer.Tree.ReConstructBinaryTree.reConstructBinaryTree;

public class Inorder {
    public static ArrayList<Integer> nonRecursiveInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode index = root;
        while (index != null) {
            stack.push(index);
            index = index.left;
        }
        while (!stack.isEmpty()) {
            index = stack.pop();
            result.add(index.val);
            if (index.right != null) {
                index = index.right;
                while (index != null) {
                    stack.push(index);
                    index = index.left;
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> recursiveInorder(TreeNode root) {
        return recursiveInorderHelper(root, new ArrayList<>());
    }

    public static ArrayList<Integer> recursiveInorderHelper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        list = recursiveInorderHelper(root.left, list);
        list.add(root.val);
        return recursiveInorderHelper(root.right, list);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);
        ArrayList<Integer> integers = nonRecursiveInorder(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
