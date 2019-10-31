package LeetCode.Tree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return num(1, n);
    }

    public int num(int begin, int end) {
        if (begin >= end) {
            return 1;
        }
        if (begin == end - 1) {
            return 2;
        }
        int result = 0;
        for (int i = begin; i <= end; i++) {
            result += num(begin, i - 1) * num(i + 1, end);
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));
    }
}
