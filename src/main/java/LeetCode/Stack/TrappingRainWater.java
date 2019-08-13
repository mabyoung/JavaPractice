package LeetCode.Stack;

public class TrappingRainWater {
    public int trap(int[] A) {
        int leftMax[] = new int[A.length];
        int rightMax[] = new int[A.length];
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            leftMax[i] = Math.max(A[i - 1], leftMax[i - 1]);
        }
        for (int i = A.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(A[i + 1], rightMax[i + 1]);
        }
        for (int i = 0; i < A.length; i++) {
            result += Math.max(Math.min(leftMax[i], rightMax[i]) - A[i], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
