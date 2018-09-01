package Company.Envision;

/**
 * Created by rui on 2018/8/27.
 */
public class Create {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private int find(int[] array, int begin, int end, int key) {
        for (int i = begin; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int position = find(inorder, inStart, inEnd, postorder[postEnd]);
        root.left = buildTreeHelper(inorder, inStart, position - 1, postorder, postStart, postStart + (position - inStart - 1));
        root.right = buildTreeHelper(inorder, position + 1, inEnd, postorder, postStart + (position - inStart), postEnd - 1);
        return root;
    }

}
