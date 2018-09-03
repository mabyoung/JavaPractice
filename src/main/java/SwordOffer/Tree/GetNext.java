package SwordOffer.Tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left  != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next != null){
            if (pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(3);
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        root.left = node1;
        root.right = node4;
        node1.right = node2;
        node1.next = root;
        node4.right = node5;
        node5.next = node4;
        System.out.println(getNext(root).val);
    }
}
