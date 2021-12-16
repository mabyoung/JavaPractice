package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class FindFarmland {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    getEnd(list, land, i, j);
                    result.add(list);
                }
            }
        }
        int[][] res = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                res[i][j] = result.get(i).get(j);
            }
        }
        return res;
    }

    public void getEnd(List<Integer> list, int[][] land, int curI, int curJ) {
        int m = land.length;
        int n = land[0].length;
        land[curI][curJ] = -1;
        if (curI + 1 < m && land[curI + 1][curJ] == 1) {
            getEnd(list, land, curI + 1, curJ);
        }
        if (curJ + 1 < n && land[curI][curJ + 1] == 1) {
            getEnd(list, land, curI, curJ + 1);
        }
        if (isBigI(land, curI, curJ) && isBigJ(land, curI, curJ)) {
            list.add(curI);
            list.add(curJ);
        }
    }

    public boolean isBigI(int[][] land, int curI, int curJ) {
        int m = land.length;
        if (curI + 1 >= m) {
            return true;
        }
        if (land[curI + 1][curJ] == 0) {
            return true;
        }
        return false;
    }

    public boolean isBigJ(int[][] land, int curI, int curJ) {
        int n = land[0].length;
        if (curJ + 1 >= n) {
            return true;
        }
        if (land[curI][curJ + 1] == 0) {
            return true;
        }
        return false;
    }
}
