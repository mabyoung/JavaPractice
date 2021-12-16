package LeetCode.Tree;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," +
                serialize(root.left) + "," +
                serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    public TreeNode deserialize(List<String> data) {
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(data.get(0)));
        data.remove(0);
        treeNode.left = deserialize(data);
        treeNode.right = deserialize(data);
        return treeNode;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node2.right = node3;
        String serialize = serializeAndDeserializeBinaryTree.serialize(node1);
        System.out.println(serialize);
        TreeNode treeNode = serializeAndDeserializeBinaryTree.deserialize(serialize);
        System.out.println(serializeAndDeserializeBinaryTree.serialize(treeNode));
    }
}
