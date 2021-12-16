package LeetCode.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GetDirections {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public class PNode {
        int parent;
        int level;
        String sign;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<Integer, PNode> map = buildMap(root);
        PNode startNode = map.get(startValue);
        PNode destNode = map.get(destValue);
        PNode leftCursor = startNode;
        PNode rightCursor = destNode;
        StringBuilder leftRoad = new StringBuilder();
        StringBuilder rightRoad = new StringBuilder();
        int targetLevel = Math.min(startNode.level, destNode.level);
        while (leftCursor.level > targetLevel) {
            leftRoad.append("U");
            leftCursor = map.get(leftCursor.parent);
        }
        while (rightCursor.level > targetLevel) {
            rightRoad.append(rightCursor.sign);
            rightCursor = map.get(rightCursor.parent);
        }
        while (leftCursor != rightCursor) {
            leftRoad.append("U");
            leftCursor = map.get(leftCursor.parent);
            rightRoad.append(rightCursor.sign);
            rightCursor = map.get(rightCursor.parent);
        }
        return leftRoad.toString() + rightRoad.reverse();
    }

    public Map<Integer, PNode> buildMap(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        Map<Integer, PNode> map = new HashMap<>();
        PNode pRoot = new PNode();
        pRoot.level = 0;
        pRoot.parent = 0;
        map.put(root.val, pRoot);
        int level = 1;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode now = linkedList.pollFirst();
                if (now.left != null) {
                    linkedList.addLast(now.left);
                    PNode pNode = new PNode();
                    pNode.parent = now.val;
                    pNode.level = level;
                    pNode.sign = "L";
                    map.put(now.left.val, pNode);
                }
                if (now.right != null) {
                    linkedList.addLast(now.right);
                    PNode pNode = new PNode();
                    pNode.parent = now.val;
                    pNode.level = level;
                    pNode.sign = "R";
                    map.put(now.right.val, pNode);
                }
            }
            level++;
        }
        return map;
    }

    public static void main(String[] args) {
        GetDirections getDirections = new GetDirections();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node5.left =node1;
        node5.right = node2;
        node1.left = node3;
        node2.left = node6;
        node2.right = node4;
        String result = getDirections.getDirections(node5, 3, 6);
        System.out.println(result);
    }
}
