package OldExams2016.Array;

import java.util.ArrayList;
import java.util.List;

public class ArrayPrint {
    public int[] arrayPrint(int[][] arr, int n) {
        List<Integer> list = new ArrayList<>();
        for (int j = n - 1; j >= 0; j--) {
            list.addAll(getLineValue(arr, n, 0, j));
        }
        for (int i = 1; i < n; i++) {
            list.addAll(getLineValue(arr, n, i, 0));
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private List<Integer> getLineValue(int[][] arr, int n, int i, int j) {
        List<Integer> result = new ArrayList<>();
        while (i != n && j != n) {
            result.add(arr[i++][j++]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayPrint arrayPrint = new ArrayPrint();
        int[] result = arrayPrint.arrayPrint(arr, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
