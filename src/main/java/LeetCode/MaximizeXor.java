package LeetCode;

import org.apache.poi.ss.formula.functions.T;

/**
 * 1707. 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * 链接：https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array
 */
public class MaximizeXor {
    private static final int MAX_BIT_LEVEL = 30;

    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int minVal = Integer.MAX_VALUE;

        public void insert(int val) {
            TreeNode cur = this;
            for (int i = MAX_BIT_LEVEL; i >= 0; i--) {
                cur.minVal = Math.min(cur.minVal, val);
                int bit = (val >> i) & 1;
                if (bit == 0) {
                    if (cur.left == null) {
                        cur.left = new TreeNode();
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = new TreeNode();
                    }
                    cur = cur.right;
                }
            }
            cur.minVal = Math.min(cur.minVal, val);
        }

        public int getMaxXorWithLimit(int val, int limit){
            TreeNode cur = this;
            int result = 0;
            for (int j = MAX_BIT_LEVEL; j >= 0; j--) {
                result *= 2;
                int xorBit = (val >> j) & 1;
                if (xorBit == 0) {
                    if (cur.right != null && cur.right.minVal <= limit) {
                        cur = cur.right;
                        result++;
                    } else if (cur.left != null && cur.left.minVal <= limit) {
                        cur = cur.left;
                    } else {
                        return -1;
                    }
                } else {
                    if (cur.left != null && cur.left.minVal <= limit) {
                        cur = cur.left;
                        result++;
                    } else if (cur.right != null && cur.right.minVal <= limit) {
                        cur = cur.right;
                    } else {
                        return -1;
                    }
                }
            }
            return result;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        TreeNode root = new TreeNode();
        for (int num : nums) {
            root.insert(num);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = root.getMaxXorWithLimit(queries[i][0], queries[i][1]);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximizeXor maximizeXor = new MaximizeXor();
        int[] result = maximizeXor.maximizeXor(new int[]{536870912, 0, 534710168, 330218644, 142254206}, new int[][]{{214004, 404207941}, {307628050, 1000000000}, {3319300, 1000000000}});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
