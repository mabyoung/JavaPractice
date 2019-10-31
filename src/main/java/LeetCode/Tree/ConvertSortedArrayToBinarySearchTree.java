package LeetCode.Tree;

/**
 * 给出一个升序排序的数组，将其转化为平衡二叉搜索树（BST）.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return buildBST(num, 0, num.length - 1);
    }

    private TreeNode buildBST(int[] num, int begin, int end) {
        if (begin > end) {
            return null;
        } else if (begin == end) {
            return new TreeNode(num[begin]);
        }
        int mid = (begin + end + 1) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildBST(num, begin, mid - 1);
        node.right = buildBST(num, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        TreeNode result = convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{1, 3});
        System.out.println(result);
    }
}
