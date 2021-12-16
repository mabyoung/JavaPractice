package LeetCode.Tree;

import java.util.LinkedList;
import java.util.List;

public class PathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(label);
        if (label == 1){
            return result;
        }
        int parent = getParentValue(label);
        while (parent != 1) {
            result.addFirst(parent);
            parent = getParentValue(parent);
        }
        result.addFirst(1);
        return result;
    }

    public int getParentValue(int num) {
        int a = num / 2;
        int lessPow = getLessPow(a);
        int morePow = lessPow * 2;
        return morePow - a + lessPow - 1;
    }

    public int getLessPow(int num) {
        int i = 1;
        while (i * 2 <= num) {
            i *= 2;
        }
        return i;
    }

    public static void main(String[] args) {
        PathInZigZagTree pathInZigZagTree = new PathInZigZagTree();
        List<Integer> result = pathInZigZagTree.pathInZigZagTree(3);
        System.out.println(result);
    }
}
