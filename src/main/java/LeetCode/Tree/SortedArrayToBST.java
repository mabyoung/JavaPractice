package LeetCode.Tree;

public class SortedArrayToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            TreeNode node = new TreeNode();
            int mid = left + (right - left) / 2;
            node.val = nums[mid];
            node.left = sortedArrayToBST(nums, left, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, right);
            return node;
        }
}
