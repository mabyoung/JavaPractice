package tiba;

import java.util.ArrayList;
import java.util.List;

public class ThreeOrders {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int[][] threeOrders (TreeNode root) {
        List<Integer> preResult = new ArrayList<>();
        preOrder(root, preResult);
        List<Integer> inResult = new ArrayList<>();
        inOrder(root, inResult);
        List<Integer> aftResult = new ArrayList<>();
        aftOrder(root, aftResult);
        int[][] result = new int[3][preResult.size()];
        for (int i = 0; i < preResult.size(); i++) {
            result[0][i] = preResult.get(i);
        }
        for (int i = 0; i < inResult.size(); i++) {
            result[1][i] = inResult.get(i);
        }
        for (int i = 0; i < aftResult.size(); i++) {
            result[2][i] = aftResult.get(i);
        }
        return result;
    }

    public void preOrder(TreeNode root, List<Integer> result){
        if(root != null) {
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
        }
    }

    public void inOrder(TreeNode root, List<Integer> result){
        if(root != null) {
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
    }

    public void aftOrder(TreeNode root, List<Integer> result){
        if(root != null) {
            aftOrder(root.left, result);
            aftOrder(root.right, result);
            result.add(root.val);
        }
    }
}
