package LeetCode.String;

public class CheckRecord {
    private static final int MOD = 1000000007;
    private static int[][][] cache;

    public boolean checkRecord1(String s) {
        char[] chars = s.toCharArray();
        int absentCount = 0, lateCount = 0;
        for (char item : chars) {
            if (item == 'L') {
                lateCount++;
                if (lateCount >= 3) {
                    return false;
                }
            } else {
                lateCount = 0;
            }
            if (item == 'A') {
                absentCount++;
                if (absentCount >= 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public int checkRecord(int n) {
        cache = new int[n + 1][3][4];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 2; j++) {
                for (int k = 0; k <= 3; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(n, 0, 0);
    }

    public int dfs(int lackCount, int absentCount, int lateCount) {
        if (absentCount >= 2 || lateCount >= 3) {
            return 0;
        }
        if (lackCount == 0) {
            return 1;
        }
        if (cache[lackCount][absentCount][lateCount] != -1) {
            return cache[lackCount][absentCount][lateCount];
        }
        int aResult = dfs(lackCount - 1, absentCount + 1, 0) % MOD;
        int lResult = dfs(lackCount - 1, absentCount, lateCount + 1) % MOD;
        int pResult = dfs(lackCount - 1, absentCount, 0) % MOD;
        int result = ((aResult + lResult) % MOD + pResult) % MOD;
        cache[lackCount][absentCount][lateCount] = result;
        return result;
    }

    public static void main(String[] args) {
        CheckRecord checkRecord = new CheckRecord();
        System.out.println(checkRecord.checkRecord(10101));
    }
}
