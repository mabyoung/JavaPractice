package SwordOffer.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
class TreeLevelNode {
    TreeNode node;
    int level;

    public TreeLevelNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class LevelPrint {
    public static void dealHelpQueue(LinkedList<TreeLevelNode> helpQueue, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> list = new ArrayList<>();
        if (helpQueue.isEmpty()) {
            return;
        }
        int level = helpQueue.getFirst().level;
        if (level % 2 == 0) {
            while (!helpQueue.isEmpty()) {
                list.add(helpQueue.pollLast().node.val);
            }
            result.add(list);
        } else {
            while (!helpQueue.isEmpty()) {
                list.add(helpQueue.pollFirst().node.val);
            }
            result.add(list);
        }
    }

    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        LinkedList<TreeLevelNode> travelQueue = new LinkedList<>();
        LinkedList<TreeLevelNode> helpQueue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        travelQueue.add(new TreeLevelNode(pRoot, 1));
        while (!travelQueue.isEmpty()) {
            TreeLevelNode first = travelQueue.pollFirst();
            if (first == null || first.node == null) {
                return result;
            }
            if (helpQueue.isEmpty() || helpQueue.getFirst().level == first.level) {
                helpQueue.addLast(first);
            } else {
                dealHelpQueue(helpQueue, result);
                helpQueue.addLast(first);
            }
            if (first.node.left != null) {
                travelQueue.addLast(new TreeLevelNode(first.node.left, first.level + 1));
            }
            if (first.node.right != null) {
                travelQueue.addLast(new TreeLevelNode(first.node.right, first.level + 1));
            }
        }
        dealHelpQueue(helpQueue, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        ArrayList<ArrayList<Integer>> result = print(root);
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
