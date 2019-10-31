package LeetCode.Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode result = new TreeNode(preorder[0]);
        int xIndex = findXInArray(preorder[0], inorder);
        result.left = buildTree(subArray(preorder, 1, xIndex), subArray(inorder, 0, xIndex - 1));
        result.right = buildTree(subArray(preorder, 1 + xIndex, preorder.length - 1), subArray(inorder, xIndex + 1, inorder.length - 1));
        return result;
    }

    private int[] subArray(int[] array, int begin, int end) {
        int[] result = new int[end - begin + 1];
        for (int i = begin; i <= end; i++) {
            result[i - begin] = array[i];
        }
        return result;
    }

    private int findXInArray(int x, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal instance = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode result = instance.buildTree(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7});
        System.out.println(result);
    }
}
