package LeetCode.Tree;

public class FindSecondMinimumValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int minValue = root.val;
        return findSecondMinimumValue(root, minValue);
    }

    public int findSecondMinimumValue(TreeNode root, int minValue) {
        if (root == null) {
            return -1;
        }
        if (root.val > minValue) {
            return root.val;
        } else {
            int leftValue = findSecondMinimumValue(root.left, minValue);
            int rightValue = findSecondMinimumValue(root.right, minValue);
            if (leftValue == -1 && rightValue == -1) {
                return -1;
            } else if (leftValue == -1) {
                return rightValue;
            } else if (rightValue == -1) {
                return leftValue;
            } else {
                return Math.min(leftValue, rightValue);
            }
        }
    }
}
