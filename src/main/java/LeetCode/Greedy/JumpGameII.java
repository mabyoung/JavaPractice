package LeetCode.Greedy;

public class JumpGameII {
    public int jump(int[] A) {
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        dp[A.length - 1] = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 1; j <= A[i] && i + j < A.length; j++) {
                dp[i] = Math.min(dp[i], dp[i + j] + 1);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{1, 2, 0, 1}));
    }
}
