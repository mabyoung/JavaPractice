package LeetCode.Array;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 1,2,3→1,3,2
 * 3,2,1→1,2,3
 * 1,1,5→1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int n = num.length;
        int index = n - 1;
        while (index > 0 && num[index] <= num[index - 1]) {
            index--;
        }
        int left = 0;
        if (index > 0) {
            int target = index - 1;
            while (index < n && num[index] > num[target]) {
                index++;
            }
            swap(num, target, index-1);
            left = target + 1;
        }
        revert(num, left, n - 1);
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public void revert(int[] num, int left, int right) {
        while (left < right) {
            int tmp = num[left];
            num[left++] = num[right];
            num[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] num = new int[]{3, 1, 2};
        nextPermutation.nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
}
