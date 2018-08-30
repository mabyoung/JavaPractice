package SwordOffer.Tree;

import java.util.Stack;

public class Convert {
    public static TreeNode convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode index = pRootOfTree;
        while (index != null) {
            stack.push(index);
            index = index.left;
        }
        TreeNode head = null;
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            index = stack.pop();
            if (head == null){
                head = index;
                pre = head;
            }else {
                pre.right = index;
                index.left = pre;
                pre = index;
            }
            if (index.right != null) {
                index = index.right;
                while (index != null) {
                    stack.push(index);
                    index = index.left;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}

