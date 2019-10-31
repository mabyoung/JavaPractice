package LeetCode.Tree;

/**
 * 给出一棵树的中序遍历和后序遍历，请构造这颗二叉树
 * 注意：
 * 保证给出的树中不存在重复的节点
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inOrder, int inBegin, int inEnd, int[] postOrder, int postBegin, int postEnd) {
        if (inBegin > inEnd || postBegin > postEnd) {
            return null;
        }
        TreeNode result = new TreeNode(postOrder[postEnd]);
        int xIndex = findXInArray(postOrder[postEnd], inOrder, inBegin, inEnd);
        result.left = buildTree(inOrder, inBegin, xIndex - 1, postOrder, postBegin, xIndex - inBegin + postBegin - 1);
        result.right = buildTree(inOrder, xIndex + 1, inEnd, postOrder, xIndex - inBegin + postBegin, postEnd - 1);
        return result;
    }

    private int findXInArray(int x, int[] array, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (x == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal instance = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode result = instance.buildTree(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println(result);
    }
}
