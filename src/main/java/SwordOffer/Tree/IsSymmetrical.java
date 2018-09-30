package SwordOffer.Tree;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    static boolean isSymmetricalHelper(TreeNode left, TreeNode right){
        if (left ==null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return isSymmetricalHelper(left.right,right.left)&&isSymmetricalHelper(left.left,right.right);
    }

    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(5);
        System.out.println(isSymmetrical(treeNode));
    }
}
