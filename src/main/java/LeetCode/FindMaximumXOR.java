package LeetCode;

import org.apache.poi.ss.formula.functions.T;

public class FindMaximumXOR {
    // 最高位的二进制位编号为 30
    private static final int HIGH_BIT = 30;

    class Tree{
        Tree left;
        Tree right;
    }

    public int findMaximumXOR(int[] nums) {
        Tree root = buildTree(nums);
        int result = 0;
        for (int num : nums) {
            result = Math.max(result, check(root, num));
        }
        return result;
    }

    public int check(Tree root, int num){
        Tree cursor = root;
        int max = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0){
                if (cursor.right != null){
                    max = max*2+1;
                    cursor = cursor.right;
                } else {
                    max = max*2;
                    cursor = cursor.left;
                }
            }else {
                if (cursor.left != null){
                    max = max*2+1;
                    cursor = cursor.left;
                } else {
                    max = max*2;
                    cursor = cursor.right;
                }
            }
        }
        return max;
    }

    public Tree buildTree(int[] nums){
        Tree root = new Tree();
        for (int num : nums) {
            Tree cursor = root;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0){
                    if (cursor.left == null){
                        cursor.left = new Tree();
                    }
                    cursor = cursor.left;
                }else {
                    if (cursor.right == null){
                        cursor.right = new Tree();
                    }
                    cursor = cursor.right;
                }
            }
        }
        return root;
    }
}
