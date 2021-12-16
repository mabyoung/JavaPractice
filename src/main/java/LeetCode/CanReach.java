package LeetCode;

public class CanReach {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n];
        int[] dpSum = new int[n];
        dp[0] = 1;
        dpSum[0] = dp[0];
        for (int i = 1; i < n; i++) {
            if (chars[i] == '0' && isOk(dpSum, minJump, maxJump, i)) {
                dp[i] = 1;
            }
            dpSum[i] = dpSum[i - 1] + dp[i];
        }
        return dp[n - 1] == 1;
    }

    /**
     * 判断current点是否可达
     */
    public boolean isOk(int[] dpSum, int minJump, int maxJump, int current) {
        int left = current - maxJump;
        int right = current - minJump;
        if (right < 0){
            return false;
        }
        if (left <= 0) {
            return dpSum[right] > 0;
        } else {
            return dpSum[right] - dpSum[left - 1] > 0;
        }
    }


    public static void main(String[] args) {
        CanReach canReach = new CanReach();
        boolean result = canReach.canReach("0000000000", 8, 8);
        System.out.println(result);
    }
}
