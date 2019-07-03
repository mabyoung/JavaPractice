package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversalII {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public class TreeNodeWithLayer{
        int layer;
        TreeNode treeNode;
        TreeNodeWithLayer(TreeNode treeNode, int layer){
            this.treeNode = treeNode;
            this.layer = layer;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        LinkedList<TreeNodeWithLayer> queue = new LinkedList<>();
        queue.addLast(new TreeNodeWithLayer(root, 1));
        int lastLayer = 1;
        while(!queue.isEmpty()){
            TreeNodeWithLayer now = queue.pollFirst();
            if (lastLayer != now.layer){
                result.add(0,new ArrayList<>(current));
                current = new ArrayList<>();
            }
            current.add(now.treeNode.val);
            if (now.treeNode.left != null){
                queue.addLast(new TreeNodeWithLayer(now.treeNode.left, now.layer+1));
            }
            if (now.treeNode.right != null){
                queue.addLast(new TreeNodeWithLayer(now.treeNode.right, now.layer+1));
            }
            lastLayer = now.layer;
        }
        result.add(0,current);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        ArrayList<ArrayList<Integer>> result = binaryTreeLevelOrderTraversalII.levelOrderBottom(node1);
        System.out.println(result);
    }
}
