package SwordOffer.Tree;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4
 */
public class KthNode {
    static int index = 0;
    static TreeNode result = null;

    static TreeNode kthNode(TreeNode pRoot, int k) {
        kthNodeHelper(pRoot, k);
        return result;
    }

    static void kthNodeHelper(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return;
        }
        kthNodeHelper(pRoot.left, k);
        if (++index == k) {
            result = pRoot;
        }
        kthNodeHelper(pRoot.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node3;
        root.right = node7;
        node3.left = node2;
        node3.right = node4;
        node7.left = node6;
        node7.right = node8;
        System.out.println(kthNode(root, 8).val);
    }
}
