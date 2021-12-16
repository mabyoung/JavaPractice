package LeetCode.Tree;

public class Tree2str {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public StringBuilder stringBuilder = new StringBuilder();

    public String tree2str(TreeNode root) {
        dfs(root);
        return stringBuilder.toString();
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            stringBuilder.append(node.val);
            if (node.left != null) {
                stringBuilder.append("(");
                dfs(node.left);
                stringBuilder.append(")");
            } else if (node.right != null) {
                stringBuilder.append("()");
            }
            if (node.right != null) {
                stringBuilder.append("(");
                dfs(node.right);
                stringBuilder.append(")");
            }
        }
    }
}
