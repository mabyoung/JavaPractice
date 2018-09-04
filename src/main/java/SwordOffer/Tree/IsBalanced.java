package SwordOffer.Tree;

/**
 * Created by rui on 2018/9/3.
 */
public class IsBalanced {
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLength = treeDepth(root.left);
        int rightLength = treeDepth(root.right);
        if (Math.abs(leftLength - rightLength) > 1) {
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        System.out.println(isBalanced(root));
    }
}
