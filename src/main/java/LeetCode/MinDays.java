package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 */
public class MinDays {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int item : bloomDay) {
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
        }
        int low = min;
        int high = max;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (isOk(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isOk(int[] bloomDay, int m, int k, int day) {
        int flowerCount = 0;
        int consecutiveNum = 0;
        for (int item : bloomDay) {
            if (item <= day) {
                consecutiveNum++;
            } else {
                consecutiveNum = 0;
            }
            if (consecutiveNum >= k) {
                flowerCount++;
                consecutiveNum = 0;
            }
        }
        return flowerCount >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
        MinDays minDays = new MinDays();
        int result = minDays.minDays(bloomDay, 2, 3);
        System.out.println(result);
    }
}
