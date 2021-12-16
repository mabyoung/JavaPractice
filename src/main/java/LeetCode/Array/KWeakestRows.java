package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class KWeakestRows {
    class Power {
        int oneNum;
        int row;

        Power(int oneNum, int row) {
            this.oneNum = oneNum;
            this.row = row;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        List<Power> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new Power(getOneNum(mat[i]), i));
        }
        list.sort((o1, o2) -> {
            if (o1.oneNum != o2.oneNum) {
                return o1.oneNum - o2.oneNum;
            }
            return o1.row - o2.row;
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).row;
        }
        return result;
    }

    public int getOneNum(int[] ints) {
        if (ints[0] == 0) {
            return 0;
        }
        int left = 0;
        int right = ints.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (ints[mid] == 0) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        KWeakestRows kWeakestRows = new KWeakestRows();
        int[] result = kWeakestRows.kWeakestRows(new int[][]{{1, 0},
                {0, 0},
                {1, 0}}, 3);
    }
}
