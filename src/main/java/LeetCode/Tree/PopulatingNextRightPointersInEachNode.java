package LeetCode.Tree;

import java.util.LinkedList;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 *
 * For example,
 * Given the following binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL`
 */
public class PopulatingNextRightPointersInEachNode {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static class Node{
        TreeLinkNode treeLinkNode;
        int layer;
        Node(TreeLinkNode t, int l){
            treeLinkNode = t;
            layer = l;
        }
    }

    public void connect(TreeLinkNode root){
        if (root == null){
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 1));
        Node last = new Node(new TreeLinkNode(0),0);
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            if (now.layer != last.layer){
                last.treeLinkNode.next = null;
            }else{
                last.treeLinkNode.next = now.treeLinkNode;
            }
            if (now.treeLinkNode.left != null){
                queue.addLast(new Node(now.treeLinkNode.left, now.layer+1));
            }
            if (now.treeLinkNode.right != null){
                queue.addLast(new Node(now.treeLinkNode.right, now.layer+1));
            }
            last = now;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new PopulatingNextRightPointersInEachNode();
        populatingNextRightPointersInEachNode.connect(null);
    }
}
