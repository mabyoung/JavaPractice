package tiba;

import Company.Envision.Tree;
import com.sun.org.apache.xerces.internal.dom.ParentNode;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public class ParentTreeNode {
        int val = 0;
        ParentTreeNode left = null;
        ParentTreeNode right = null;
        ParentTreeNode parent = null;
    }

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        ParentTreeNode parentRoot = new ParentTreeNode();
        buildParentTreeNode(root, parentRoot);
        ParentTreeNode o1Node = findNode(parentRoot, o1);
        ParentTreeNode o2Node = findNode(parentRoot, o2);
        List<Integer> list = new ArrayList<>();
        getParentRoad(o1Node, list);
        return lowestCommonAncestor(o2Node, list);
    }

    public int lowestCommonAncestor(ParentTreeNode node, List<Integer> list) {
        if (node == null) {
            return -1;
        }
        if (list.contains(node.val)) {
            return node.val;
        }
        return lowestCommonAncestor(node.parent, list);
    }

    public void getParentRoad(ParentTreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        getParentRoad(node.parent, list);
    }

    public void buildParentTreeNode(TreeNode root, ParentTreeNode parentRoot) {
        if (root == null) {
            return;
        }
        parentRoot.val = root.val;
        ParentTreeNode leftNode = new ParentTreeNode();
        parentRoot.left = leftNode;
        leftNode.parent = parentRoot;
        buildParentTreeNode(root.left, leftNode);
        ParentTreeNode rightNode = new ParentTreeNode();
        parentRoot.right = rightNode;
        rightNode.parent = parentRoot;
        buildParentTreeNode(root.right, rightNode);
    }

    public ParentTreeNode findNode(ParentTreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        ParentTreeNode leftResult = findNode(root.left, val);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode();
        root.val = 0;
        TreeNode left = new TreeNode();
        left.val = 1;
        TreeNode right = new TreeNode();
        right.val = 2;
        root.left = left;
        root.right = right;
        int result = lowestCommonAncestor.lowestCommonAncestor(root, 1, 2);
        System.out.println(result);
    }
}
