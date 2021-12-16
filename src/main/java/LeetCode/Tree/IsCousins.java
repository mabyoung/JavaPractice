package LeetCode.Tree;

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;
import java.util.List;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 */
public class IsCousins {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class TreeNodeWithHigh{
        TreeNode treeNode;
        int high;
        TreeNodeWithHigh(){

        }
        TreeNodeWithHigh(TreeNode treeNode, int high){
            this.treeNode = treeNode;
            this.high = high;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNodeWithHigh cursorX = new TreeNodeWithHigh();
        TreeNodeWithHigh cursorY = new TreeNodeWithHigh();
        TreeNode parentX = new TreeNode();
        TreeNode parentY = new TreeNode();
        LinkedList<TreeNodeWithHigh> queue = new LinkedList<>();
        queue.add(new TreeNodeWithHigh(root, 0));
        while(!queue.isEmpty()){
            TreeNodeWithHigh treeNodeWithHigh = queue.pollFirst();
            if (treeNodeWithHigh.treeNode.val == x){
                cursorX = treeNodeWithHigh;
                if (cursorY.treeNode != null){
                    break;
                }
            }
            if (treeNodeWithHigh.treeNode.val == y){
                cursorY = treeNodeWithHigh;
                if (cursorX.treeNode != null){
                    break;
                }
            }
            if (treeNodeWithHigh.treeNode.left != null){
                queue.addLast(new TreeNodeWithHigh(treeNodeWithHigh.treeNode.left, treeNodeWithHigh.high+1));
                if (treeNodeWithHigh.treeNode.left.val == x){
                    parentX = treeNodeWithHigh.treeNode;
                }
                if (treeNodeWithHigh.treeNode.left.val == y){
                    parentY = treeNodeWithHigh.treeNode;
                }
            }
            if (treeNodeWithHigh.treeNode.right != null){
                queue.addLast(new TreeNodeWithHigh(treeNodeWithHigh.treeNode.right, treeNodeWithHigh.high+1));
                if (treeNodeWithHigh.treeNode.right.val == x){
                    parentX = treeNodeWithHigh.treeNode;
                }
                if (treeNodeWithHigh.treeNode.right.val == y){
                    parentY = treeNodeWithHigh.treeNode;
                }
            }
        }
        return cursorX.high == cursorY.high && cursorX.treeNode != cursorY.treeNode && parentX != parentY;
    }

    public static void main(String[] args) {
        IsCousins isCousins = new IsCousins();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        node3.right = node5;
        boolean result = isCousins.isCousins(root, 4, 5);
        System.out.println(result);
    }
}
