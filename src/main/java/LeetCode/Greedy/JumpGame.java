package LeetCode.Greedy;

public class JumpGame {
    public boolean canJump(int[] A) {
        int index = 0;
        while (A[index] != 0) {
            index += A[index];
            if (index >= A.length - 1) {
                return true;
            }
        }
        return index == A.length - 1;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
