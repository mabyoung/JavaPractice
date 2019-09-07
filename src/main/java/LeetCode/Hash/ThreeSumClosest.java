package LeetCode.Hash;

import java.util.Arrays;

/**
 * 给出含有n个整数的数组s，找出s中和加起来的和最接近给定的目标值的三个整数。返回这三个整数的和。你可以假设每个输入都只有唯一解。
 * 例如，给定的整数 S = {-1 2 1 -4}, 目标值 = 1.↵↵   最接近目标值的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[2];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(threeSumClosest.threeSumClosest(new int[]{1,2,3},1));
    }
}
