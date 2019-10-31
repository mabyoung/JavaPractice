package CrackingTheCodingInterview.Tree;

/**
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
 * 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
 */
public class MinimalBST {
    public int buildMinimalBST(int[] vals) {
        int high = 1;
        int nodeCount = 1;
        while (nodeCount < vals.length) {
            nodeCount = (nodeCount + 1) * 2 - 1;
            high++;
        }
        return high;
    }

    public static void main(String[] args) {

    }
}
