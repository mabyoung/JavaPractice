package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '|') {
                list.add(i);
            }
        }
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int indexA = getIndexA(list, a);
            int indexB = getIndexB(list, b);
            if (indexA < indexB) {
                result[i] = list.get(indexB) - list.get(indexA) - (indexB - indexA);
            }
        }
        return result;
    }

    public int getIndexA(List<Integer> list, int a) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < a) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getIndexB(List<Integer> list, int b) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) > b) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        int[] result = platesBetweenCandles.platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}});
        System.out.println(result);
    }
}
