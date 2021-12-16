package LeetCode.Tree;

import java.util.*;

public class VerticalTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class TreeNodeSoul {
        int val;
        int row;
        int col;

        TreeNodeSoul(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<TreeNode, TreeNodeSoul> map = new HashMap<>();
        map.put(root, new TreeNodeSoul(root.val, 0, 0));
        traver(root, map);
        List<TreeNodeSoul> treeNodeSoulList = new ArrayList<>(map.values());
        treeNodeSoulList.sort(new Comparator<TreeNodeSoul>() {
            @Override
            public int compare(TreeNodeSoul o1, TreeNodeSoul o2) {
                if (o1.col != o2.col) {
                    return o1.col - o2.col;
                }
                if (o1.row != o2.row) {
                    return o1.row - o2.row;
                }
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < treeNodeSoulList.size(); i++) {
            if (i != 0 && treeNodeSoulList.get(i).col == treeNodeSoulList.get(i - 1).col) {
                result.get(result.size() - 1).add(treeNodeSoulList.get(i).val);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(treeNodeSoulList.get(i).val);
                result.add(tmp);
            }
        }
        return result;
    }

    public void traver(TreeNode root, Map<TreeNode, TreeNodeSoul> map) {
        if (root == null) {
            return;
        }
        TreeNodeSoul treeNodeSoul = map.get(root);
        if (root.left != null) {
            map.put(root.left, new TreeNodeSoul(root.left.val, treeNodeSoul.row + 1, treeNodeSoul.col - 1));
            traver(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right, new TreeNodeSoul(root.right.val, treeNodeSoul.row + 1, treeNodeSoul.col + 1));
            traver(root.right, map);
        }
    }
}
