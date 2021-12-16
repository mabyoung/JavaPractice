package LeetCode.Simulation;

public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isOverlap(rec1[0], rec1[2], rec2[0], rec2[2]) && isOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
    }

    private boolean isOverlap(int a1, int a2, int b1, int b2) {
        return b1 < a2 && b2 > a1;
    }
}
