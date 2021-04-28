package SwordOffer.Dynamic;

public class CutRope {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        int result = cutRope.cutRope(8);
        System.out.println(result);
    }
}
