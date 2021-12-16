package LeetCode.Num;

import java.util.HashMap;
import java.util.Map;

public class XorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length + 1];
        xor[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
        }
        return result;
    }


    public static void main(String[] args) {
        XorQueries xorQueries = new XorQueries();
        int[] result = xorQueries.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        for (int item : result) {
            System.out.println(item);
        }
    }
}
