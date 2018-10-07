package SwordOffer.Tree;

import java.util.ArrayList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Serialize {
    static int index = -1;

    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "#,";
        }
        sb.append(root.val).append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    static TreeNode deserialize(String str) {
        index++;
        if (str == null || str.equals("")) {
            return null;
        }
        String[] split = str.split(",");
        if (index >= split.length || split[index].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(split[index]));
        node.left = deserialize(str);
        node.right = deserialize(str);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node4;
        node4.right = node3;
        node3.right = node2;
        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        ArrayList<Integer> integers = PrintFromTopToBottom.printFromTopToBottom(deserialize);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
